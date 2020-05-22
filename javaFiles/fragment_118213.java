PrivateKey oPrivateKey = (PrivateKey) keystore.getKey(sAlias,null);


                           Provider p = keystore.getProvider();
                           // data to signed
                           byte[] data ="this is the just for test".getBytes();
                           // Signing the data
                           Signature sig = Signature.getInstance("SHA1withRSA");
                           sig.initSign(oPrivateKey);

                           sig.update(data);
                           byte[] signature = sig.sign(); // the digital signature

                           Signature verifier = Signature.getInstance("SHA1withRSA", p);
                           verifier.initVerify(oPublicCertificate);
                           verifier.update(data);
                           System.out.println("the verification result "+verifier.verify(signature));