X509Certificate certificate =...
X509Certificate intermediate = ...
try{
    certificate.verify(intermediate.getPublicKey());
        //Verification ok.    intermediate  is the issuer
    } catch (Exception e){}
}