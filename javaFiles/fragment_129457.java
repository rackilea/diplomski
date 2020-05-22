synchronized(lock) {
    try {
        Socket socket = new Socket (uri.getHost(), uri.getPort() == -1 ? 80 : uri.getPort());
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}