StringBuilder total = new StringBuilder(inputStream.available());
String line;
bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
while((line = bufferedReader.readLine()) != null && !line.equals("EOF")) {
      total.append(line).append('\n');
}