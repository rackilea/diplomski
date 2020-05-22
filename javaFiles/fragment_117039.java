String file = "/tmp/x";
DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

String inputString = "Test";
byte[] toServer = inputString.getBytes();
dos.writeInt(toServer.length);
dos.write(toServer);

DataInputStream dis = new DataInputStream(new FileInputStream(file));
int arrLength = dis.readInt();

byte[] fromClient = new byte[arrLength];
dis.read(fromClient, 0, fromClient.length);
// works fine for me
assertEquals(inputString, new String(fromClient));