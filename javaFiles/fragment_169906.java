String result = null;
String requestInput = formatXmlRequest(input[0]); //returns a SOAP request String
URL url;
HttpURLConnection connection = null;
OutputStreamWriter out = null;

try {
    url = new URL(WEB_SERVICE_URL);
    connection = (HttpURLConnection) url.openConnection();
    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setRequestProperty("Content-Type", "application/soap+xml");
    connection.setRequestProperty("Accept", "application/soap+xml");

    out = new OutputStreamWriter(connection.getOutputStream());
    out.write(requestInput);
    out.flush();

    StringBuilder stringBuilder = new StringBuilder();
    int responseCode = connection.getResponseCode();

    if(responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
    } else {
        Log.d("BAD RESPONSE", "Response from server: "+responseCode);
    }

    result = stringBuilder.toString();

} catch (IOException ioe) {
    ioe.printStackTrace();
} finally {
    if(connection != null) connection.disconnect();
    if(out != null) {
        try {
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

return result;