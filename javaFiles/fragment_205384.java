BufferedReader reader = new BufferedReader(new InputStreamReader(attachment));
StringBuilder out = new StringBuilder();
String line;
while ((line = reader.readLine()) != null) {
    out.append(line);
}