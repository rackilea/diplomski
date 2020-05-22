Socket s = serverSocket.accept();
ByteArrayOutputStream compressed = new ByteArrayOutputStream();
GZIPOutputStream compressor = new GZIPOutputStream(compressed);

Msg m = new Msg("123", "123", karte);
m.writeObject (compressor);
compressor.close();

OutputStream fout = s.getOutputStream();
fout.write (compressed.toByteArray() );
fout.close ();