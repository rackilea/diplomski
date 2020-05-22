// PROBLEM: If I pass "ivParamSpec", I get "java.security.InvalidAlgorithmParameterException: Wrong parameter type: PBE expected"
// Whereas if I pass pbeParamSpec, I get "java.security.InvalidAlgorithmParameterException: Missing parameter type: IV expected"
// What to do?
cipherDecrypt.init(
    Cipher.DECRYPT_MODE,
    key,
    ivParamSpec
    //pbeParamSpec
    );