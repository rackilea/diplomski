socket = new java.net.Socket(inetAddress,MainActivity.wifiModulePort);
//read input msg from server
DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
dataOutputStream.writeChars(CMD);
System.out.println(CMD);
dataOutputStream.close();

socket.close();