PublicKey publicKey = yourRequest.getPublicKey();
int keySize
if (publicKey instanceof RSAPublicKey) {
    keySize = ((RSAPublicKey)publicKey).getPublicExponent().bitLength();
} else if (publicKey instance DSAPublicKey) {
    keySize = ((DSAPublicKey)publicKey).getY().bitLength();
} else {
    // handle other public key types.
}