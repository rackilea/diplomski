public void isAvailable(){

    // first check if there is a WiFi/data connection available... then:

    URL url = new URL("URL HERE");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestProperty("Connection", "close");
    connection.setConnectTimeout(10000); // Timeout 10 seconds
    connection.connect();

    // If the web service is available
    if (connection.getResponseCode() == 200) {
        return true;
    }
    else return false;
}