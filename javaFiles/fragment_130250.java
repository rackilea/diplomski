String directory = "C:/Users/UCD/eclipse-workspace/metrics_cal/src/test/resources/xerces2-j-Xerces-J_2_8_0";
String file = "\"C:/Users/UCD/eclipse-workspace/metrics_cal/src/test/resources/xerces2-j-Xerces-J_2_8_0/xerces2-j-Xerces-J_2_8_0/src/org/apache/xerces/jaxp/SAXParserImpl.java\";";
try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
    Path path1 = Paths.get(file);
    if(paths.anyMatch(path1::equals)){
        // do something
    }
} catch (IOException e) {
    e.printStackTrace();
}