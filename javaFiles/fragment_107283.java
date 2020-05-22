NSMutableData *derivedKey = [NSMutableData dataWithLength:keySize];
int result = CCKeyDerivationPBKDF(
    kCCPBKDF2,               // algorithm
    password.UTF8String,     // password
    password.length,         // passwordLength
    salt.bytes,              // salt
    salt.length,             // saltLen
    kCCPRFHmacAlgSHA1,       // PRF
    rounds,                  // rounds
    derivedKey.mutableBytes, // derivedKey
    derivedKey.length);      // derivedKeyLen