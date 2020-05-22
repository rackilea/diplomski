public static void main(String[] args) {
       String searchText = "searchtext";
       searchText = searchText.replaceAll(" ", "%20");
       String accountKey="key_ID";

    byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes());
    String accountKeyEnc = new String(accountKeyBytes);
    URL url;
    try {
        url = new URL(
                "https://api.datamarket.azure.com/Bing/Search/v1/Composite?Sources=%27Web%27&Query=%27" + searchText + "%27&$format=JSON");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Authorization", "Basic " + accountKeyEnc);

    BufferedReader br = new BufferedReader(new InputStreamReader(
            (conn.getInputStream())));
    StringBuilder sb = new StringBuilder();
    String output;
    System.out.println("Output from Server .... \n");
    //write json to string sb
    while ((output = br.readLine()) != null) {

        sb.append(output);

    }

    conn.disconnect();
     //find webtotal among output      
   int find= sb.indexOf("\"WebTotal\":\"");
   int startindex = find + 12;


   int lastindex = sb.indexOf("\",\"WebOffset\"");

    System.out.println(sb.substring(startindex,lastindex));

    } catch (MalformedURLException e1) {
        e1.printStackTrace();
    } catch (IOException e) {

        e.printStackTrace();
    }


}