String originalValue = "this is a test";

String encryptedValue 
    = new EncryptStringProvider(new PlainStringProvider(originalValue));

String decryptedValue
    = new DecryptStringProvider(new PlainStringProvider(encryptedValue));

assert decryptedValue == originalValue;