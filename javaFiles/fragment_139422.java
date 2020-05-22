OutputStream outToClient = null;
try {
    ServerSocket welcomeSocket = new ServerSocket(6789);
    while (true) {
        Socket connectionSocket = welcomeSocket.accept();
        outToClient = new BufferedOutputStream(
                connectionSocket.getOutputStream());
        outToClient.write("sign up accepted you can now sign in\n"
                .getBytes("UTF-8"));
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (outToClient != null) {
        try {
            outToClient.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    if (outToClient != null) {
        try {
            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}