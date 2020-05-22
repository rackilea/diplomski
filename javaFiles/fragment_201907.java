private ArrayList<X509Certificate> parseCerts( String fileName, String pwd ) {
   ArrayList certsFromP12File = new ArrayList();
   String cmdLine = "/usr/bin/openssl pkcs12 -info -in " + fileName + " -clcerts -nokeys -passin pass:" + pwd;

   String line;

   Process p = Runtime.getRuntime().exec( cmdLine );

   BufferedReader input = new BufferedReader( new InputStreamReader( p.getInputStream() ) );

   boolean readingCert = false;
   boolean gotCertToProcess = false;
   String certString;

   while ((line=input.readLine()) != null ) {
      if ( line.contains("-----BEGIN CERTIFICATE-----") ) {
         readingCert = true;
      }
      if ( readingCert ) {
         certString += line + System.getProperty("line.separator");
      }
      if ( line.contains("-----END CERTIFICATE-----") ) {
         readingCert = false;
         getCertToProcess = true;
      }
      if ( gotCertToProcess ) {
         X509Certificate cert = null;
         byte[] cert_bytes = certString.getBytes();
         ByteArrayInputStream certInputStream = new ByteArrayInputStream(cert_bytes);
         cert = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate( certInputStream );
         certsFromP12File.add( cert );
         gotCertToProcess = false;
         certString = "";
      }
   }
   input.close();

   return certsfromP12File;
}