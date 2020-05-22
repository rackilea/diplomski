RandomAccessFile raf = new RandomAccessFile("d:\\host.pk8", "r");
byte[] buf = new byte[(int)raf.length()];
raf.readFully(buf);
raf.close();
PKCS8EncodedKeySpec kspec = new PKCS8EncodedKeySpec(buf);
KeyFactory kf = KeyFactory.getInstance("RSA");
PrivateKey privKey = kf.generatePrivate(kspec);