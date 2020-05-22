public class HttpClient {
    private final String DOWNLOAD_URL = "http://my.original.json.url";

    public String readJsonDataFromUrl() throws IOException {
        URLConnection urlConnection = getUrlConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuffer content = new StringBuffer();

        String readLine = "";
        while ((readLine = reader.readLine()) != null)  {
            content.append(readLine);
        }

        return content.toString();
    }

    private URLConnection getUrlConnection() throws IOException {
        URL jsonLocator = new URL(getConnectionString());

        return jsonLocator.openConnection();
    }

    protected String getConnectionString()  {
        return DOWNLOAD_URL;
    }
}