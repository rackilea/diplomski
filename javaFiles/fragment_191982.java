String url = "http://sampleurl.info/actions/checklogin.asp?userName=klingenhaeger&password=droid&device=android";
try {
    URL u = new URL(url);
    InputStream is = u.openStream(); // Opens streaming connection to url
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    StringBuffer result = new StringBuffer(); // Buffer to store saved data
    String input = null;

    while((input = reader.readLine()) != null) {
        // Read data until the end of the stream
        result.append(input);
    }

    // Do something with result here
} catch (IOException e) {
    e.printStackTrace();
}