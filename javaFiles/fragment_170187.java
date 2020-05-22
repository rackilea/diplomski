PipedInputStream pin = new PipedInputStream();
PipedOutputStream pout = new PipedOutputStream(pin);
EncryptionPipe pipe = new EncryptionPipe(5, pout, in, cipher, mac, metaData);
//EncryptionPipe(int interval, OutputStream out, InputStream in
//              ,Cipher cipher, Mac mac, byte[] metaData)
pipe.start();
return pin;