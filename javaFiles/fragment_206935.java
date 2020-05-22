BigInteger ONE = new BigInteger("1");
SecureRandom rand = new SecureRandom();

BigInteger d, e, n;
BigInteger p = BigInteger.probablePrime(128, rand);
BigInteger q = BigInteger.probablePrime(128, rand);
BigInteger phi = (p.subtract(ONE)).multiply(q.subtract(ONE));

n = p.multiply(q);
e = new BigInteger("65537");
d = e.modInverse(phi);

String string = "this is a test";
BigInteger plainText = new BigInteger(string.getBytes());
BigInteger cipherText = plainText.modPow(e, n);
BigInteger originalMessage = cipherText.modPow(d, n);
String decrypted = new String(originalMessage.toByteArray());

System.out.println("original: " + string);
System.out.println("decrypted: " + decrypted);