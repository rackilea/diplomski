String[] signatureAlgorithms = new String[] {"RIPEMD160withECDSA", "SHA224withECDDSA", "SHA256withECDDSA", "SHA384withECDDSA", "SHA512withECDDSA", "SHA1withECDSA", "NONEwithECDSA", "SHA224withECDSA", "SHA256withECDSA", "SHA384withECDSA", "SHA512withECDSA", "SHA3-224withECDSA", "SHA3-256withECDSA", "SHA3-384withECDSA", "SHA3-512withECDSA"};
for(String algorithm : signatureAlgorithms) {
    Signature sig;
    Logger.getLogger(CardManager.class.getName()).log(Level.INFO, "trying aloorithm " + algorithm + ": ");
    sig = Signature.getInstance(algorithm, "BC");
    ...