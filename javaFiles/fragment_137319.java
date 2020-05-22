HttpURLConnection connection = (HttpURLConnection) (new URL("http://" + account + ".table.core.windows.net/"+urlPath)).openConnection();

    signRequestSK(connection, account, key);

    connection.connect();

    ByteArrayOutputStream sink = new ByteArrayOutputStream();

    copy(connection.getInputStream(), sink, 3000);  
    byte[] downloadedFile = sink.toByteArray();
    String str = new String(downloadedFile, "UTF8");


    AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setTitle("Title");
    alert.setMessage(str);
    alert.show();