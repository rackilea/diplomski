try (ByteArrayOutputStream plainTextStream = new ByteArrayOutputStream()) 
{
    // -- c# like CryptoStream
    try (CipherOutputStream decrypterStream = 
             new CipherOutputStream(plainTextStream, cipher)) 
    {
        // -- binaryWriter like c#
        try (DataOutputStream binaryWriter = new DataOutputStream(decrypterStream)) 
        {
            // -- Encrypt Data
            //Decrypt Cipher Text from Message
            binaryWriter.write(encryptedMessage,
                               nonSecretPayloadLength + iv.length,
                               encryptedMessage.length 
                                 - nonSecretPayloadLength 
                                 - iv.length 
                                 - sentTag.length);
        }

        //Return Plain Text
        //decrypterStream.flush();

    } finally {
        return plainTextStream.toByteArray();
    }

} catch (IOException e) {
    e.printStackTrace();
}