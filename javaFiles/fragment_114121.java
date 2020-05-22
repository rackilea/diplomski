final URL url = new URL("https://example.com");
final HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
final BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
String input;

while ((input = br.readLine()) != null){
    System.out.println(input);
}