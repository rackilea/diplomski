byte[] msg = line.getBytes(Charset.forName("UTF-8"));
byte[] output = new byte[msg.length + 2];
System.arraycopy(msg, 0, output, 0, msg.length);
output[msg.length] = (byte) 13;
output[msg.length] = (byte) 10;
outputStream.write(output);