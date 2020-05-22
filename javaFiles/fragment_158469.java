URL url = new URL(params[0]);
BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
StringBuilder builder = new StringBuilder();
String current;
while ((current = reader.readLine()) != null) {
    builder.append(current);
}
line = builder.toString();
reader.close();