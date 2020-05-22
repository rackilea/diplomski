//Create a Socket with ip and port number
Socket s = new Socket("127.0.0.1", 4242);

//Get input from user
Scanner in = new Scanner(System.in);
System.out.println("Please enter a message");
String clientMessage = in.nextLine();

//Make a printwriter and write the message to the socket
PrintWriter writer = new PrintWriter(s.getOutputStream());
writer.println(clientMessage); // <- println
writer.flush();                // <- flush

//StreamReader to read the response from the server
InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
BufferedReader reader = new BufferedReader(streamReader);

//Get the response message and print it to console
String responseMessage = reader.readLine();
System.out.println(responseMessage);
reader.close();
writer.close();                // <- new location for close (*)