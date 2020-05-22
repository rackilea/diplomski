String param = "str=YOURSTRING";
    String request = "http://localhost:8084/";
    URL url = new URL(request);
    HttpURLConnection connection = (HttpURLConnection)
    url.openConnection();          
    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setInstanceFollowRedirects(false);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setRequestProperty("charset", "utf-8");
    connection.setRequestProperty("Content-Length", "" +  Integer.toString(param.getBytes().length));
    connection.setUseCaches (false);

    DataOutputStream out = new DataOutputStream(connection.getOutputStream ());
    out.writeBytes(param);
    out.flush();
    out.close();
    connection.disconnect();