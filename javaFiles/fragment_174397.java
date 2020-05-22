InputStream inStream = null;
 try {
     inStream = new FileInputStream("fileName-of-cert");
     CertificateFactory cf = CertificateFactory.getInstance("X.509");
     X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
 } finally {
     if (inStream != null) {
         inStream.close();
     }
 }