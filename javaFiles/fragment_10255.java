StringBuilder builder = new StringBuilder();
FileReader fileReader = new FileReader("fileName");
BufferedReader reader = new BufferedReader(fileReader);
for (String line = reader.readLine(); line != null; line = reader.readLine()) {
    builder .append(line);
}
String xml = builder .toString();