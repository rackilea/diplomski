private static boolean shouldExit = false;

public static void main(String args[]) {
    System.out.println("Sensor Server Is Running");

    try (ServerSocket listener = new ServerSocket(port)) {
        acceptLoop(listener);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private static void acceptLoop(ServerSocket listener) throws IOException {
    while (!shouldExit) {
        // accept() blocks until a connection is made
        Socket client = listener.accept();
        new sensorHandler(client).start();
    }
}