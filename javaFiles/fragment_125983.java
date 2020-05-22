// Code for reading, writing is very similar
byte cmd = (byte)is.read();

byte[] ip = new byte[4];
is.read(ip, 0, 4);

byte action = (byte)is.read();
byte extra  = (byte)is.read();