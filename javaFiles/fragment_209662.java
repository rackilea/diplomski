private static String queryWeb(String host, String path) throws IOException {
    InetAddress requestedWebIP = InetAddress.getByName(host);
    if ((path == null) || (path.equals(""))) {
        path = "/";
    }
    try (
            Socket toWebSocket = new Socket(requestedWebIP, 80);
            BufferedOutputStream outPutStream = new BufferedOutputStream(toWebSocket.getOutputStream());
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(toWebSocket.getInputStream()))
    ) {
        String request = "HEAD " + path + " HTTP/1.1\r\n" +
                "Host: " + host + "\r\n\r\n";
        outPutStream.write(request.getBytes());
        outPutStream.flush();
        String input;
        String result = "";

        while (!(input = inputStream.readLine()).equals("")) {
            System.out.println(input);
            result = result + input + "\n";
        }

        return result;

    } catch (IOException e) {
        System.out.println("An error occurred during IO");
        e.printStackTrace();
    }
    return null;
}