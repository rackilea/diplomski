int x = getX();
int y = getY();
// let's assume we have a 16Bit / 2Byte range for both values (practica)
byte[] message = new byte[4];
message[0] = (byte) (x >> 8) & 0xff;
message[1] = (byte) x & 0xff;
message[2] = (byte) (y >> 8) & 0xff;
message[3] = (byte) y & 0xff;
sendViaSocket(message);