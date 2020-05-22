try (
    Socket s = new Socket("127.0.0.1", 4242);
    Scanner in = new Scanner(System.in);
    PrintWriter writer = new PrintWriter(s.getOutputStream());
    InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
    BufferedReader reader = new BufferedReader(streamReader);
) {
    //Create a Socket with ip and port number

    //Get input from user
    System.out.println("Please enter a message");
    String clientMessage = in.nextLine();

    //Make a printWriter and write the message to the socket
    writer.println(clientMessage);
    writer.flush();

    //StreamReader to read the response from the server

    //Get the response message and print it to console
    String responseMessage = reader.readLine();
    System.out.println(responseMessage);
} catch (IOException ex) {
    ex.printStackTrace(); // (**)
}