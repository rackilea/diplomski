FileInputStream is = new FileInputStream( "cert.pkcs7" );
CertificateFactory cf = CertificateFactory.getInstance( "X.509" );
Iterator i = cf.generateCertificates( is ).iterator();
while ( i.hasNext() ) 
{
   Certificate c = (Certificate)i.next();
   // TODO encode c as Base64...
}