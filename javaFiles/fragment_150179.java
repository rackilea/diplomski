byte[] originalData = "This is a static message test.".getBytes("UTF-8");
byte[] signature = Base64.getDecoder().decode(theOutputFromTheCSharpProgram);
Signature verifier = new Signature("SHA1withRSA");
verifier.initVerify(publicKey);
verifier.update(originalData);
System.out.println(verifier.verify(signature));