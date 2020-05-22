try {
    HttpsURLConnection conn = (HttpsURLConnection)new URL(<your-https-url-here>).openConnection();
    conn.setRequestMethod("GET");
    conn.setDoInput(true);
    conn.setSSLSocketFactory(sslSocketFactory);

    int responseCode = conn.getResponseCode();
    System.out.println("RESPONSE: " + responseCode);

    InputStream inputstream = conn.getInputStream();
    InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
    BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

    String line = null;
    String htmlResponse = "";

    while ((line = bufferedreader.readLine()) != null) {
        htmlResponse += line + "\n";
        //System.out.println("html: " + line);
    }
} catch (ProtocolException e) {
    e.printStackTrace();
} catch (MalformedURLException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}