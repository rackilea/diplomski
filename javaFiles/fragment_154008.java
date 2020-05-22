private RangeData getRangeData(RangeInfo r) throws IOException, GeneralSecurityException, CryptoException {

    // used for encrypted files
    long blockStart = r.getStart();
    long blockEnd = r.getEnd();
    long blockLength = blockEnd - blockStart + 1;

    // encrypted files, it must be access in blocks of 16 bytes
    if(datafile.isEncrypted()){
        blockStart -= blockStart % 16;
        blockEnd = blockEnd | 15; // nearest multiple of 16 for length n = ((n−1)|15)+1
        blockLength = blockEnd - blockStart + 1;
    }

    try ( final FileChannel channel = FileChannel.open(services.getPhysicalFile(datafile).toPath()) )
    {
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, blockStart, blockLength);
        InputStream inputStream = new ByteBufferInputStream(mappedByteBuffer);
        if(datafile.isEncrypted()) {
            String encryptionKeyRef = (String) settingsManager.getSetting(AppSetting.DEFAULT_ENCRYPTION_KEY);
            inputStream = new FileEncryptionUtil().getCipherInputStream(inputStream,
                    EncodeUtil.decodeSeedValue(encryptionKeyRef), AESCipher.DECRYPT_MODE);
            long skipStart = r.getStart() - blockStart;
            inputStream = new BlockInputStream(inputStream, skipStart, r.getLength()); // this will trim the data to n bytes at last
        }
        return new RangeData(r, inputStream);
    }
}