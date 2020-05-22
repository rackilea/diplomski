byte[] message_hash = // ...
byte[] candidate_message = // ...

PublicKey pub = // ...

Signature dsa = Signature.getInstance("SHA1withECDSA");

dsa.initVerify(pub);

dsa.update(candidate_message);

boolean success = dsa.verify(message_hash);