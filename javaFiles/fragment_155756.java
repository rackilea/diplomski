public static void main (String[] args) throws IOException {

    // get your own Id and Secret by registering at https://api.imgur.com/oauth2/addclient
    String Client_ID = "";
    String Client_Secret = ""; 

    String YOUR_USERNAME = " "; // enter your imgur username
    String YOUR_REQUEST_URL = "https://api.imgur.com/3/account/YOUR_USERNAME";

    URL imgURL = new URL(YOUR_REQUEST_URL);
    HttpURLConnection conn = (HttpURLConnection) imgURL.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Authorization", "Client-ID " + CLIENT_ID);

    BufferedReader bin = null;
    bin = new BufferedReader(new InputStreamReader(conn.getInputStream()));

//below will print out bin
    String line;
    while ((line = bin.readLine()) != null)
        System.out.println(line);
    bin.close();
}