public static void SendRequest(String method, String notifications) {
    String url = SERVICE_BASE_URL + method;

    JSONObject requestObject = new JSONObject();
    JSONArray notificationsArray =null;
    JSONObject mainRequest = new JSONObject();
    try {
        notificationsArray = new JSONArray(notifications);
        requestObject.put("notifications", notificationsArray);

        mainRequest.put("request", requestObject);
    } catch (JSONException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }


    HttpURLConnection connection = null;
    try
    {
        URL server = new URL(url);
        connection = (HttpURLConnection) server.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
        writer.writeBytes(mainRequest.toString());
        writer.flush();
        writer.close();

        parseResponse(connection);
    }
    catch (Exception e)
    {
        System.out.println("An error occurred: " + e.getMessage());
    }
    finally
    {
        if (connection != null)
        {
            connection.disconnect();
        }
    }
}