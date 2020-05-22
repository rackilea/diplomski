#!/bin/sh

# set the working directory
DIR=$(cd "$(dirname "$0")"; pwd) 

# extract first fit java version installed
jre_path=$(/usr/libexec/java_home -V 2>&1 |
while IFS= read -r line
do
    if [[ "$jre_found" ==  "true" ]]; then
        break
    fi
    version=$(echo $line | cut -d ' ' -f 1|sed 's/^ *//;s/ *$//' | cut -d ' ' -f 1 | sed 's/^ *//;s/ *$//')
    major=$(echo $version | cut -d. -f1)
    minor=$(echo $version | cut -d. -f2)
    array=(${line// /}) 
    array_size=${#array[@]}
    let "last_index=array_size-1"
    path=${array[ $last_index ]}

    if [[ $major == 1 ]]; then
        if [[ $minor -gt 7 && $minor -lt 11 ]]; then
            echo $path
            jre_found="true"
        fi
    elif [[ $major -gt 7 &&  $major -lt 11 ]]; then
        echo $path
        jre_found="true"
    fi
done)

# execute our jar file
$jre_path/bin/java -jar "$DIR"/myApp.jar