File file = new File("yourdata.xml");
FileInputStream fin = new FileInputStream(file);
byte[] xmlData = new byte[(int) file.length()];
fin.read(xmlData);
fin.close();
String TEST_XML_STRING = new String(xmlData, "UTF-8");