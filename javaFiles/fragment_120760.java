value1=3; value2 = -5;
dout= new DataOutputStream(socket.getOutputStream());
dout.writeInt(value1);
dout.writeInt(value2);

DataInputStream dIn = new DataInputStream(socket.getInputStream());
int value1 = dIn.readInt();  
int value2 = dIn.readInt();