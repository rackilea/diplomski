HttpURLConnection connection = null;
    try {
        URL url = new URL("www.google.com");
        connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        connection.getInputStream();
                    // do something with the input stream here

    } catch (MalformedURLException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    } finally {
        if(null != connection) { connection.disconnect(); }
    }