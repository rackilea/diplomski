Socket socket = new Socket(serverHost, serverPort);
DataInputStream dis = new DataInputStream(socket.getInputStream());
int lengthFromServer = 4;
byte resultArray[] = new byte[lengthFromServer];
dis.readFully(result);
String result = new String(resultArray);