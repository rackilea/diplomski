public static String soapHttpRequest(RequestInfo re) {
    HttpURLConnection connection = null;
    OutputStreamWriter wr = null;
    BufferedReader rd = null;
    StringBuilder sb = null;
    String line = null;

    URL serverAddress = null;

    System.setProperty("http.proxyHost", "proxy.my.com");
    System.setProperty("http.proxyPort", "80");
    System.setProperty("https.proxyHost", "proxy.my.com");
    System.setProperty("https.proxyPort", "80");

    try {
                    serverAddress = new URL("https://site.com/service/default.asp");
        // set up out communications stuff
        connection = null;

        // Set up the initial connection
        connection = (HttpURLConnection) serverAddress.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "text/xml; charset=utf-8");
        connection.setRequestProperty("SOAPAction", 
              "https://site.com/service/default.asp#Method");
        OutputStream reqStream = connection.getOutputStream();
        reqStream.write(getSoapMessageString(re).getBytes());
        connection.connect();


        // read the result from the server
        rd = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        sb = new StringBuilder();

        while ((line = rd.readLine()) != null) {
            sb.append(line + '\n');
        }
        String val = sb.toString();
        System.out.println(val);
        return val;

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (ProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // close the connection, set all objects to null
        connection.disconnect();
        rd = null;
        sb = null;
        wr = null;
        connection = null;
              // Closing to prevent issues with local calls
        System.setProperty("http.proxyHost", "");
        System.setProperty("http.proxyPort", "");
        System.setProperty("https.proxyHost", "");
        System.setProperty("https.proxyPort", "");
    }
    return null;
}