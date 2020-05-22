String signature = header + "." + claim_set;
String privateKeyString = "-----BEGIN PRIVATE KEY-----\nturlututu123\n-----END PRIVATE KEY-----\n";
privateKeyString = private_key.replaceAll("-----END PRIVATE KEY-----", "").replaceAll("-----BEGIN PRIVATE KEY-----", "").replaceAll("\n", "");

Signature privateSignature = Signature.getInstance("SHA256withRSA");

KeyFactory keyFactory=KeyFactory.getInstance("RSA");

PrivateKey privateKey = keyFactory.generatePrivate(
    new PKCS8EncodedKeySpec(
        Base64.getDecoder().decode(privateKeyString)
    )
);

privateSignature.initSign(privateKey);

privateSignature.update(signature.getBytes("UTF-8"));
bytes = privateSignature.sign();
signature = Base64.getUrlEncoder().encodeToString(bytes);