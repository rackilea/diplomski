public class EncryptionPipe extends Thread {
    ...
    @Override
    public void run() {
        try {
            mac.update(metaData);
            out.write(metaData);

            byte[] buf = new byte[1024];
            int bytesRead = 0;
            byte[] crypted;
            byte[] hmac;
            while ((bytesRead = in.read(buf)) != -1) {
                if (bytesRead < buf.length) {
                    //the doFinal methods add padding if necessary, important detail!
                    crypted = cipher.doFinal(buf, 0, bytesRead);
                    hmac = mac.doFinal(crypted);

                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    bytes.write(crypted);
                    bytes.write(hmac);
                    crypted = bytes.toByteArray();
                    bytesRead = crypted.length;
                    bytes.close();
                } else {
                    crypted = cipher.update(buf, 0, bytesRead);
                    mac.update(crypted, 0, bytesRead);
                }
                out.write(crypted, 0, bytesRead);
                synchronized (this) {
                    this.wait(interval);
                }
            }
            out.close();
            ...
        }
    }
}