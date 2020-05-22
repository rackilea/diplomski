client = new Socket(hostname, port);
        callback.onConnection();
        OutputStream writer = client.getOutputStream();
        InputStream reader = client.getInputStream();
        byte[] buffer = new byte[1024 * 1024];
        reader.read(buffer);