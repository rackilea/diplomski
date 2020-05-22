if (!socket.isClosed()) {
    int id = 1
    while (isStreaming) {
        try {
            if (id > 2) id = 1;
            byte[] buffer = loadContent(id + ".jpg");
            assert buffer != null;
            Log.i("Web Server", "Size of image: " + buffer.length + "bytes");

            output.write(("--boundary\r\n" +
                          "Content-Type: image/jpeg\r\n" +
                          "Content-Length: " + buffer.length + "\r\n\r\n").getBytes());
            output.write(buffer);
            Thread.sleep(100);
            Log.i("Web Server", "Current id: " + id);
            id++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}