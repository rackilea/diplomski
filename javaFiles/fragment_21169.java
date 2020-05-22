void getViaStreamConnection(String url) throws IOException {
     StreamConnection c = null;
     InputStream s = null;
     try {
         c = (StreamConnection)Connector.open(url);
         s = c.openInputStream();
         int ch;
         while ((ch = s.read()) != -1) {
             ...
         }
     } finally {
         if (s != null)
             s.close();
         if (c != null)
             c.close();
     }
 }