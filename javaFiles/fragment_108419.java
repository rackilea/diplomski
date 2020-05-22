public byte[] getEncodedPKCS1() {
   try {
        if (externalDigest != null)
            digest = externalDigest;
        else
            digest = sig.sign();

     //skipped content