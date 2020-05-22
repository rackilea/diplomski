URL url = new URL("http://www.example.com/index.html");
BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
String line;

while ((line = reader.readLine()) != null) {
    checkLineForTextAndAddLinkOrWhatever(line);
}
reader.close();