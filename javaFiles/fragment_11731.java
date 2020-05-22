public class HandShakingTask extends AsyncTask<String, Void, Void> {

@Override
protected Void doInBackground(String... urls) {
    try {
        URL url = new URL(urls[0]);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        System.out.println(connection.getResponseMessage());

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            System.out.println("OK");
            // otherwise, if any other status code is returned, or no status
            // code is returned, do stuff in the else block
        } else {
            System.out.println("WRONG");
            // Server returned HTTP error code.
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}