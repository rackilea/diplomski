BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));  
Socket clientSocket = new Socket("localhost", 3333); //3333 is the port on which the    server is listening   
DataOutputStream outToConsumer = new DataOutputStream(clientSocket.getOutputStream());
BufferedReader inFromConsumer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));   //Only if consumer sends something in reply
sentence = inFromUser.readLine();   
outToServer.writeBytes(sentence + '\n');
modifiedSentence = inFromConsumer.readLine();