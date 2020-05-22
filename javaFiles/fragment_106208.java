File file = new File("1.xml");
int size = (int) file.length();
byte[] bytes = new byte[size];
FileInputStrea in = new FileInputStream(file);
in.read(bytes);
in.close();
String xml = new String(bytes, "ISO-8859-1");