Certificate cert = ....
PublicKey publicKey = cert.getPublicKey();
byte[] originalPublicKey = publicKey.getEncoded();
byte[] modifiedPublicKey = java.util.Arrays.copyOf(originalPublicKey , originalPublicKey .length);// make a copy
modifiedPublicKey[0] = !modifiedPublicKey[0]; // modify something
print(originalPublicKey); // your "print" method - implement it how you like it e.g., Arrays.toString(originalPublicKey)
print(modifiedPublicKey ); // your "print" method - implement it how you like it e.g., Arrays.toString(modifiedPublicKey)