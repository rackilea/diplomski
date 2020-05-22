String urlParameters = "client_id=" + clientID
            + "&client_secret=" + clientSecret
            + "&grant_type=authorization_code"
            + "&redirect_uri=" + redirectURI
            + "&code="+code;

connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
connection.setRequestProperty("charset", "utf-8");
connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));

DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
wr.writeBytes(urlParameters);
wr.flush();
wr.close();