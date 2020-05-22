try
{
    InetAddress serverAddress = InetAddress.getByName("servername");
    try (
        Socket socket = new Socket(serverAddress, 9999);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    ) {
        while ((userInput = input.readLine()) != null) {
            System.out.println(input.readLine());
        }
    }
}
catch (...)