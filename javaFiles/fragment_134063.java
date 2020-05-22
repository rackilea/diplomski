EncryptionInfo info = new EncryptionInfo(filesystem);
    Decryptor d = Decryptor.getInstance(info);

    try {
        if (!d.verifyPassword(password)) {
            throw new RuntimeException("Unable to process: document is encrypted");
        }

        InputStream dataStream = d.getDataStream(filesystem);
        HSSFWorkbook wb = new HSSFWorkbook(dataStream);
        // parse dataStream

    } catch (GeneralSecurityException ex) {
        throw new RuntimeException("Unable to process encrypted document", ex);
    }