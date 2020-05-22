URL obj = new URL("http://www.mudomaine.com/login.php);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("POST"); 
    String datas = "my_login=Administrator&my_password=s3cred0n3";
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(datas);
    wr.flush();
    wr.close();