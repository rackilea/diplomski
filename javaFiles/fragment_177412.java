File javaFile = new File(filePath);
BufferedReader in = new BufferedReader(new FileReader(javaFile));
final StringBuffer buffer = new StringBuffer();
String line = null;
while (null != (line = in.readLine())) {
     buffer.append(line).append("\n");
}