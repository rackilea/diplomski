ObjectOutputStream oos = null;
    String[] login = { "xxxxxxxx", "xxxxxxxx" };
    URL url = new URL(
            "http://xxxxxxx.xxxxxxxxx.xxxxxxxxxxx.com/xxxxx/login/1");
    try {
        // creates a HTTP connection
        HttpURLConnection httpConn = (HttpURLConnection) url
                .openConnection();
        // httpConn.setUseCaches(false);
        httpConn.setReadTimeout(10000 /* milliseconds */);
        httpConn.setConnectTimeout(15000 /* milliseconds */);
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type", "application/xml");
        httpConn.connect();
        OutputStream outputStream = httpConn.getOutputStream();
        oos = new ObjectOutputStream(outputStream);
        oos.writeObject(login);
        outputStream.close();
        InputStream is = httpConn.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        try {
            boolean check = (boolean) ois.readObject();
            String[] logback = (String[]) ois.readObject();
            System.out.println(check + " " + logback[0] + " " + logback[1]);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println();
    } finally {
        if (oos != null) {
            oos.close();
        }
    }