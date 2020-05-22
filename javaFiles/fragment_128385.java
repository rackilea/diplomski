String fileType = arg[0]; // == XML
String material = arg[1]; // == S
String fileName = arg[2]; // == xmltest.xml
if (fileType.equals("XML") && material.equals("S")) {
    parseXMLStudentFile(fileName);
} else { // ...
}