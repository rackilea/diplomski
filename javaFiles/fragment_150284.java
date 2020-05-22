ByteArrayOutputStream baos = new ByteArrayOutputStream();
Streamer stream = new Streamer( baos, "myNetaFile.neta", env );
net.write( stream );
byte[] bytesToEncode = baos.toByteArray();
stream.flush();
String encoded = Base64.encodeBase64String( bytesToEncode );