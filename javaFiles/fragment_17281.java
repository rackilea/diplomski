BigInteger crtCoefficient = ((RSAPrivateCrtKey)keyPair.getPrivate()).getCrtCoefficient();
BigInteger primeExponentP = ((RSAPrivateCrtKey)keyPair.getPrivate()).getPrimeExponentP();
BigInteger primeExponentQ = ((RSAPrivateCrtKey)keyPair.getPrivate()).getPrimeExponentQ();
BigInteger p = ((RSAPrivateCrtKey)keyPair.getPrivate()).getPrimeP();
BigInteger q = ((RSAPrivateCrtKey)keyPair.getPrivate()).getPrimeQ();
BigInteger publicExponent = ((RSAPrivateCrtKey)keyPair.getPrivate()).getPublicExponent();
BigInteger privateExponent = ((RSAPrivateCrtKey)keyPair.getPrivate()).getPrivateExponent();
RSAPrivateCrtKeySpec crtKeySpec = new RSAPrivateCrtKeySpec(modulus, publicExponent, privateExponent, p, q, primeExponentP, primeExponentQ, crtCoefficient);
...
PrivateKey privateKey = kf.generatePrivate(crtKeySpec);