//read input msg from server
DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
dataOutputStream.writeUTF(CMD);
System.out.println(CMD);
dataOutputStream.close();

socket.close();