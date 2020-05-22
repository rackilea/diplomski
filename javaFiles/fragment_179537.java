Writer output = null;
String text = "Www.criandcric.com. is my site";
File file = new File("write.txt");
output = new BufferedWriter(new FileWriter(file));
output.write(text);
output.close();