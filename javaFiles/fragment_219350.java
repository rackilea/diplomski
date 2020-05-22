URL url = new URL("http://www.lauftreff.de/laeufe/halbmarathon-1-2017.html");
URLConnection conn = url.openConnection();
InputStreamReader input = new InputStreamReader(conn.getInputStream(),StandardCharsets.ISO_8859_1);
BufferedReader bi = new BufferedReader(input);
String inputLine;
while((inputLine = bi.readLine()) != null){
    inputLine = StringEscapeUtils.unescapeHtml4(inputLine);
    System.out.println(inputLine);
}