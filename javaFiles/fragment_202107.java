DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//in server
String txt = "Hello from Server to Client\n";           
outputStream.write(txt.getBytes());

//in client 
String message = inputStream.readLine();

socket.close();