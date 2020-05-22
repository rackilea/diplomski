public static void start() {
    try {
        ServerSocket serverSocket = new ServerSocket(4567);
        //tells server to listen on 4567
 ....

if (start < 5) {
        System.out.println("Closing binds and Restarting" + start);

        start();
}