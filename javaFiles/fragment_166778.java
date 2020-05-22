File file = new File("Hello.txt");
FileInputStream fis = new FileInputStream(file);
byte[] bytes = new byte[(int) file.length()];
fis.read(bytes);
fis.close();
String text = new String(bytes, "UTF-8");
System.out.println(text.substring(text.indexOf("START"), text.lastIndexOf("END")));