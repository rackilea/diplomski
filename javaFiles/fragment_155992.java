public static void main(String[] args) throws Exception{

    URL oracle = new URL("https://anapioficeandfire.com/api/characters/583");
    HttpURLConnection httpcon = (HttpURLConnection) oracle.openConnection();
    httpcon.addRequestProperty("User-Agent", "Mozilla/4.0");

    BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine);
    in.close();
}