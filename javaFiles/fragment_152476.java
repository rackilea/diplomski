public boolean testSocket(String serversList) {        
    String[] sockets = serversList.split(",");
    int unactive = 0;
    for (int i = 0; i < sockets.length; i++) {
        try {
            String[] socket = sockets[i].split(":");
            (new Socket(socket[0], Integer.valueOf(socket[1]))).close();
        } catch (IOException e) {
            unactive++;
        }
    }
    if (unactive < sockets.length) return true;
    return false;
}