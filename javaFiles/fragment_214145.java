private static final byte[] buffer  = new byte[60416];


   public void copiar(String serverPath, String localPath) 
throws Exception {
       SmbFile serverFile  = new SmbFile("smb://192.168.43.80/tratermik/balanca.txt");
       File localFile      = new File("sdcard/sistemas/tratermic/balanca.txt);

       InputStream in      = new SmbFileInputStream(serverFile);
       OutputStream out    = new FileOutputStream(localFile);

       try {
           while (true) {
               synchronized (buffer) {
                   int amountRead = in.read(buffer);
                   if (amountRead == -1) {
                       break;
                   }
                   out.write(buffer, 0, amountRead);
               }
           }

       } catch (Exception e) {
           throw e;

       } finally {
           if (in != null) { in.close();}
           if (out != null) {out.close();}
       }
   }
}