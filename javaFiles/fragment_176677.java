public void sendJson(String jsonString) {
    String httpURL = "http://ip_of_my_server/phpServer/receiver2.php";
    HttpConnection httpConn = null;

    try {
        httpConn = getHttpConnection(httpURL, jsonString.getBytes());

        if(httpConn.getResponseCode() == 200) {
            //If you need the output, then read it. Otherwise comment it.
            byte[] data = IOUtilities.streamToBytes(httpConn.openInputStream());
            String response = new String(data);
            System.out.println("!!!!!!!!!!!!!! Response is: " + response);
        }
    } catch (Exception e) {
    }
    finally {
        try {
            httpConn.close();
        } catch (Exception e2) {
        }
    }
}