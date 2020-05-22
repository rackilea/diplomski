public static void main(String args[]) throws IOException {
       public final static String   AUTH_KEY_FCM    = "server key";
       public final static String   API_URL_FCM     = 
                                      "https://fcm.googleapis.com/fcm/send";

    // Method to send Notifications from server to client end.

    // userDeviceIdKey is the device id you will query from your database

    String authKey = AUTH_KEY_FCM; // You FCM AUTH key
    String FMCurl = API_URL_FCM;

    URL url = new URL(FMCurl);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    conn.setUseCaches(false);
    conn.setDoInput(true);
    conn.setDoOutput(true);

    conn.setRequestMethod("POST");
    conn.setRequestProperty("Authorization", "key=" + authKey);
    conn.setRequestProperty("Content-Type", "application/json");

    JSONObject json = new JSONObject();
    json.put("to",
            "Device key");
    JSONObject info = new JSONObject();
    info.put("title", "Demo"); // Notification title
    info.put("body", "Hello Test notification"); // Notification body
    json.put("notification", info);

    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    wr.write(json.toString());
    wr.flush();
    conn.getInputStream();

    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

    String output;
    System.out.println("Output from Server .... \n");
    while ((output = br.readLine()) != null) {
        System.out.println(output);
    }
}