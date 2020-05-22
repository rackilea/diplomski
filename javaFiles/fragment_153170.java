String publicKeyB64 = "MIGHAoGBAOX+TFdFVIKYyCVxWlnbGYbmgkkmHmEv2qStZzAFt6NVqKPLK989Ow0RcqcDTZaZBfO5"
        + "5JSVHNIKoqULELruACfqtGoATfgwBp4Owfww8M891gKNSlI/M0yzDQHns5CKwPE01jD6qGZ8/2IZ"
        + "OjLJNH6qC9At8iMCbPe9GeXIPFWRAgER";
// ok, you may need to use the Base64 decoder of bouncy or Android instead
byte[] decoded = Base64.getDecoder().decode(publicKeyB64);
org.bouncycastle.asn1.pkcs.RSAPublicKey pkcs1PublicKey = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(decoded);
BigInteger modulus = pkcs1PublicKey.getModulus();
BigInteger publicExponent = pkcs1PublicKey.getPublicExponent();
RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, publicExponent);
KeyFactory kf = KeyFactory.getInstance("RSA");
PublicKey generatedPublic = kf.generatePublic(keySpec);
System.out.printf("Modulus: %X%n", modulus);
System.out.printf("Public exponent: %d ... 17? Why?%n", publicExponent); // 17? OK.
System.out.printf("See, Java class result: %s, is RSAPublicKey: %b%n", generatedPublic.getClass().getName(), generatedPublic instanceof RSAPublicKey);