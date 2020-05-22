#!/usr/bin/bash

# check the number of command line arguments
clear
echo "### CodeCrawler starting"

# test input parameters
if [[ $# < 2 ]]; then
    echo "usage: % crawl inputFile/inputDir outputDir"
    exit -1
fi    

# the working directory is C:\CodeCrawler
cd /cygdrive/c/CodeCrawler

# find all files tha require analysis
if [ -d $1 ]; then
  find $1 | grep "\.java$" > allFiles$2
  find $1 | grep "\.jsp$" >> allFiles$2
  find $1 | grep "\.htm$" >> allFiles$2
  find $1 | grep "\.html$" >> allFiles$2
else if [ -f $1 ]; then
    find $1 > allFiles$2
  fi
fi

# get total no. of files to be scanned
totalFiles=$(cat allFiles$2 | wc -l)
scannedNoOfFiles=0;
echo "### No of files to scan : $totalFiles"

# create the index.html file
rm -rf $2; mkdir $2;cd $2
echo "<html><body bgcolor=\"#ccffff\"><h3>$1</h3>" > dir.html

# crawl through the entire directory 
for rootFile in $( cat ../allFiles$2 ); do

    scannedNoOfFiles=$((scannedNoOfFiles+1));echo;echo "### Scanning $scannedNoOfFiles / $totalFiles"

    # create a dir for the output
    rootFileDir=$(echo $rootFile | tr '/' '\n' | tail -1).dir
    echo "### Storing output in $rootFileDir"
    rm -rf $rootFileDir
    mkdir $rootFileDir
    cd $rootFileDir

    # append to the index.html file
    rootFileDirName=$(echo $rootFile | tr '/' '\n' | tail -1)
    echo "<a href=\"$rootFileDir/index.html\" target=\"fileFrame\">$rootFileDirName</a><br>" >> ./../dir.html

    # obtain all external jsp references
    touch jsp.cwl
    cat $rootFile | grep "\.jsp" | tr "'\"\?<>=,()[] " '\n' | sed 's/\.\.//g' | grep "\.jsp" | grep -v "http" | sort -u > tmp
    for line in $(cat tmp);do
        echo /$line | sed 's/\/\//\//g' >> jsp.cwl
    done 

    # obtain all external js references
    touch js.cwl
    cat $rootFile | sed 's/\.jsp//g' | grep "\.js" | tr "'\"\?<>=,()[] " '\n' | sed 's/\.\.//g' | grep "\.js" | grep -v "http" | sort -u > tmp
    for line in $(cat tmp);do
        echo /$line | sed 's/\/\//\//g' >> js.cwl
    done  

    # obtain all external css references
    touch css.cwl
    cat $rootFile | grep "\.css" | tr "'\"\?<>=,()[] " '\n' | sed 's/\.\.//g' | grep "\.css" | grep -v "http" | sort -u > tmp
    for line in $(cat tmp);do
        echo /$line | sed 's/\/\//\//g' >> css.cwl
    done   

    # obtain all external htm references
    touch htm.cwl
    cat $rootFile | grep "\.htm" | tr "'\"\?<>=,()[] " '\n' | sed 's/\.\.//g' | grep "\.htm" | grep -v "http" | sort -u > tmp
    for line in $(cat tmp);do
        echo /$line | sed 's/\/\//\//g' >> htm.cwl
    done  

    # obtain all database references
    touch db.cwl
    cat $rootFile | grep -i "select.*from" | sed 's/from/\nfrom/g' | sed 's/FROM/\nFROM/g' | grep -i "from" | sed 's/from//g'| sed 's/FROM//g' | awk '{print $1}' | tr '[;"]' ' ' | uniq > db.cwl
    cat $rootFile | sed "s/.prepareStatement(\"/\nX_X_X/g" | grep "X_X_X" | sed "s/X_X_X//g" | tr '[ ,\$ ]' '\n' | head -1 | uniq >> db.cwl

    # obtain all references to java classes. we include everything with signature com. and exclude "www" and "flight"
    cat $rootFile | tr '["=%;/<>@\t) ]' '\n' | grep "com\." | grep -v "codepassion\." | grep -v "www" | grep -v "flight" | sort -u > tmp
    echo > tmpDirectReferences
    cat tmp | grep "(" >> tmpDirectReferences    # directReferences are like au.com.mycompany.servlet.MiscServlet.getCckey()
    echo > tmpDirectReferences
    cat tmp | grep -v "(" >> tmpJavaFiles            # javaFiles are like Person aPerson; ... aPerson.getPolicy()

    # read directReferences and produce the class.cwl file by identifying class and method
    echo "#D# Looking for direct references" 
    while read classLine; do
        methodName=$(echo $classLine | tr '\.' '\n' | tail -1 | sed 's/(//g')
        className=$(echo $classLine | sed "s/\.$methodName(//g" | tr '[()]' ' ')
        echo $methodName >> $className.cwl
        echo "### class: $className   method:$methodName" 
        echo $className >> tmpDirectReferencesReformed
    done < tmpDirectReferences

    # read javaFiles every fully qualified class name and grab the class from it. then grab the method from it
    echo "#J# Looking for indirect references" 
    while read classLine; do
        className=$(echo $classLine | tr '\.' '\n' | tail -1)
        echo "#F# find: $classLine"
        # indirect references are in the form className objectName ... and then objectName.methodName
        cat $rootFile | grep "$className .*;" | sed -e "s/$className[ \t]\+\([a-zA-Z0-9_]\+\)[ \t]*[;=].*/\1/g" | sed 's/^[ \t]*//;s/[ \t]*$//' | sort -u > tmp$ClassName
        # read tmp$className and find all properties and method references
        while read methodLine; do
        cat $rootFile | grep "$methodLine\." | tr '[ (]' '\n' | sed "s/$methodLine\./\n$methodLine\./g" | grep "$methodLine\." | sort -u | grep -v "[\"%]" | grep -v ".com." | tr '.' '\n' | grep -v "$methodLine" >> $classLine.cwl  
        done < tmp$ClassName
        # direct references are className.methodName
        cat $rootFile | grep "[ ()\"']$className\." | tr ' (' '\n' | grep "$className" | tr '.' '\n' | grep -v "$className"  >> $classLine.cwl
        cat $rootFile | grep "$className\." | tr ' (' '\n' | grep "$className" | tr '.' '\n' | grep -v "$className"  >> $classLine.cwl
    done < tmpJavaFiles

    # consolidate all information to generate the html files
    echo "### Generating index.html"
    rootFileName=$(echo $rootFile | tr '/' '\n' | tail -1)
    touch index.html
    echo "<html><head><title>$rootFileName</title></head><body bgcolor=\"#ffffcc\">" >> index.html
    echo "<h3>$rootFile</h3>" >> index.html 
    # put all java classes
    echo "<br><h3>Referenced classes</h3>">> index.html
    cat tmpDirectReferencesReformed | uniq >> tmpJavaFiles;cat tmpJavaFiles | uniq > tmpJavaFilesU; mv tmpJavaFilesU tmpJavaFiles
    while read aLine; do
        echo "- <a href=\"$aLine.html\" target=\"methodFrame\">$aLine</a><br>" >> index.html 
    done < tmpJavaFiles
    # put all DBs
    echo "<br><h3>Referenced Tables</h3>">> index.html
    while read aLine; do
        echo "- $aLine<br>" >> index.html
    done < db.cwl
    # put all JSPs
    echo "<br><h3>Referenced JSPs</h3>">> index.html
    while read aLine; do
        echo "- $aLine<br>" >> index.html
    done < jsp.cwl
    # put all JSs
    echo "<br><h3>Referenced JavaScript</h3>">> index.html
    while read aLine; do
        echo "- $aLine<br>" >> index.html
    done < js.cwl
    # put all htms
    echo "<br><h3>Referenced htm</h3>">> index.html
    while read aLine; do
        echo "- $aLine<br>" >> index.html
    done < htm.cwl
    # put all css
    echo "<br><h3>Referenced css</h3>">> index.html
    while read aLine; do
        echo "- $aLine<br>" >> index.html
    done < css.cwl
    echo "</body></html>" >> index.html

    # generate a html for each class file and put all accessed methods in it
    for aLine in $( ls *.cwl ); do
        cat $aLine | uniq > tmp; mv tmp $aLine   
        fileName=$(echo $aLine | sed 's/\.cwl//g')
        echo "#G# generating $fileName.html"
        echo "<html><body bgcolor=\"#ffddee\">" >> $fileName.html
        echo "<h3>$fileName</h3>" >> $fileName.html
        for bLine in $( cat $aLine | sort ); do
          echo "$bLine<br>" >> $fileName.html
        done
        echo "</body></html>" >> $fileName.html
    done

    # cleanup and return
    #rm *.cwl *tmp* 
    cd ..

done

echo "</body></html>" >> ./dir.html
rm ../allFiles$2
echo "### CodeCrawler finished"