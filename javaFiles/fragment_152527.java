DataInputStream in = new DataInputStream(socket.getInputStream());
byte aByte = in.readByte();
int anInt = in.readInt();
int anotherInt = in.readInt();
short andAShort = in.readShort(); // 11 bytes read :-)
byte[] lotOfBytes = new byte[anInt];
in.readFully(lotOfBytes);