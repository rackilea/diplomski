ServerSocket ss = new ServetSocket(port);
Socket socket = ss.accept();
InputStream in = socket.getInputStream();
byte [] sizeBuffer = new byte[5];
in.read(sizeBuffer);
byte [] dataBuffer = new byte[Integer.valueOf(""+new String(sizeBuffer)]; 
in.read(dataBuffer);