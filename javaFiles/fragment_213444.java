bReader = new BufferedReader(new FileReader(JSON_FILE));
String line;

while ((line = bReader.readLine()) != null) {
    System.out.println(line);
}