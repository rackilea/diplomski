FileInputStream fin = ...
BufferedInputStream bin = new BufferedInputStream(fin, 2048);
String name = readLine(bin);
String lineWithSize = readLine(bin);
int size = Integer.parseInt(lineWithSize);
byte[] data = new byte[size];
bin.read(data, 0, size);
bin.close();