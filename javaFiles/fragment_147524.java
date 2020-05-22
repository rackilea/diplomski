if (doc.isEncrypted())
    {
        StandardDecryptionMaterial sdm = new StandardDecryptionMaterial(PDF_USER_PASSWORD);
        doc.openProtection(sdm);
        // don't call decrypt() here
    }