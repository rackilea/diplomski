XMLCipher cipher = XMLCipher.getInstance(XMLCipher.AES_128);
cipher.init(XMLCipher.ENCRYPT_MODE, secretKey);

// Create a KeyInfo for the EncryptedData
EncryptedData encryptedData = cipher.getEncryptedData();
org.apache.xml.security.keys.KeyInfo keyInfo = new org.apache.xml.security.keys.KeyInfo(inputDocument);
keyInfo.add(encryptedKey);
encryptedData.setKeyInfo(keyInfo);

Document result = cipher.doFinal(inputDocument, inputDocument);