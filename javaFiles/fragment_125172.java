// If Key Usage flags are present, we must respect them:
int keyFlagsEncountered = 0;
boolean keyUsageAllowsEncryption = false;

Iterator<PGPSignature> i = key.getSignatures();
while(i.hasNext()) {
    PGPSignature signature = i.next();
    int keyFlags = signature.getHashedSubPackets().getKeyFlags();
    keyFlagsEncountered += keyFlags;

    boolean isEncryptComms = (keyFlags & KeyFlags.ENCRYPT_COMMS) > 0;
    boolean isEncryptStorage = (keyFlags & KeyFlags.ENCRYPT_STORAGE) > 0;
    // Other KeyFlags available here (AUTHENTICATION, SIGN_DATA, CERTIFY_OTHER).

    if (isEncryptComms || isEncryptStorage) {
        keyUsageAllowsEncryption = true;
    }
}

// However, if Key Usage flags are not present (older key, or key generation process simply did not include the flags) 
// then we still attempt to use an encryption key using the existing methods:
keyUsageAllowsEncryption = keyFlagsEncountered == 0 || keyUsageAllowsEncryption;