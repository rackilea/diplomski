StringWriter writer = new StringWriter();
char[] buffer = new char[8192];
int charsRead;
while ((charsRead = bufferedReader.read(buffer)) > 0) {
    writer.write(buffer, 0, charsRead);
}
response = writer.toString();