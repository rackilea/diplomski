@Override        
 public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)  throws CertificateException {

 if (certs == null || certs.length == 0) {  
      throw new IllegalArgumentException("null or zero-length certificate chain");  
 }  

 if (authType == null || authType.length() == 0) {  
            throw new IllegalArgumentException("null or zero-length authentication type");  
  }  

   //Check if certificate send is your CA's
    if(!certs[0].equals(caCertificate)){
         try
         {   //Not your CA's. Check if it has been signed by your CA
             certs[0].verify(caCertificate.getPublicKey())
         }
         catch(Exception e){   
              throw new CertificateException("Certificate not trusted",e);
         }
    }
    //If we end here certificate is trusted. Check if it has expired.  
     try{
          certs[0].checkValidity();
      }
      catch(Exception e){
            throw new CertificateException("Certificate not trusted. It has expired",e);
      }  
}