File file = new File("input.xml");
byte[] data;
try (FileInputStream fis = new FileInputStream(file)) {
   data = new byte[(int) file.length()];
    fis.read(data);
}
String input = new String(data, "UTF-8");
String tag = "<row>";
String newXML = input.substring(0, input.indexOf(tag) + tag.length()) + "your value" + input.substring(input.indexOf(tag) + tag.length(), input.length());
try (FileWriter fw = new FileWriter(file)) {
    fw.write(newXML);
}
System.out.println("XML Updated");