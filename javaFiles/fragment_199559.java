import org.apache.commons.lang.RandomStringUtils
import groovy.util.XmlSlurper
import static groovy.io.FileType.*

void stripTag(File inputFile, String outputFile) {
    def XMLTag='Details'

    fileContents = inputFile.getText('UTF-8')

    def xmlFile=new XmlSlurper().parseText(fileContents)

    def myPayload= new String(xmlFile.'**'.find{node-> node.name() == XMLTag}*.text().toString())


    def file = new File(outputFile)
    w = file.newWriter() 
    w << myPayload.substring(1, myPayload.length()-1)
    w.close()
}

// This will match all files in the current directory with the file extension .xml
new File(".").eachFileMatch(FILES, ~/.*\.xml/) { File input ->
    // Set the output file name to be <file_name>_out.txt
    // Change this as you need
    stripTag(input, input.name + "_out.txt")
}