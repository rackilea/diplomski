private static boolean isReachable(String url)
{
    try
    {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();

        return responseCode == 200;
    }
    catch (IOException e)
    {
        return false;
    }
}