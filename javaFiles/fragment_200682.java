public boolean URLIsReachable(String urlString)
{
    try
    {
        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url
                .openConnection();
        responseCode = urlConnection.getResponseCode();
        urlConnection.disconnect();
        return responseCode != 200;
    } catch (MalformedURLException e)
    {
        e.printStackTrace();
        return false;
    } catch (IOException e)
    {
        e.printStackTrace();
        return false;
    }
}