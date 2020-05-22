//Encryption Mechanism.
  try (FileInputStream fis = new FileInputStream(file)) {

       byte[] buffer = new byte[1024 * 1024];
       byte[] cipherBlock = new byte[encCipher.getOutputSize(buffer.length)];
       int cipherBytes;
       int read;
       while ((read = fis.read(buffer)) != -1) {
              cipherBytes = encCipher.update(buffer, 0, read, cipherBlock);
              dos.write(cipherBlock, 0, cipherBytes);
        }
        cipherBytes = encCipher.doFinal(cipherBlock, 0); //let out the last block out of the encryptor.
        dos.write(cipherBlock, 0, cipherBytes);
     } catch (ShortBufferException | IllegalBlockSizeException | BadPaddingException ex) {
              Logger.getLogger(PeersController.class.getName()).log(Level.SEVERE, null, ex);
       }