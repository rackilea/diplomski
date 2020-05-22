public static void main(String[] args) throws IOException {
    String order = "datahere";

    // Try-with-resource statement will close your socket automatically
    try (Socket clientSocket = new Socket("XXX.XX.XX.XX", 9300)) {
        // Send to the sever the order encoded in ASCII
        clientSocket.getOutputStream().write(order.getBytes("ASCII"));
        // Sleep until we have bytes to read available
        while (clientSocket.getInputStream().available() == 0) {
            Thread.sleep(100L);
        }
        // Create the buffer of exactly the amount of bytes available without blocking
        byte[] data = new byte[clientSocket.getInputStream().available()];
        // Read the bytes from the server and put it into the buffer
        int bytes = clientSocket.getInputStream().read(data, 0, data.length);
        // Decode what has been read from the server that was encoded in ASCII
        String responseData = new String(data, 0, bytes, "ASCII");
        System.out.println("From server: " + responseData);
    }
}