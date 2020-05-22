ServerSocket ss = new ServerSocket(PORT);
while (LISTENING) {
    Socket sock = ss.accept();
    Handler handler = new Handler(sock);
    new Thread(handler).start();
    //With the LISTENING variable dealt with as well
}