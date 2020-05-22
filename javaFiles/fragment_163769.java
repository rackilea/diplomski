public boolean encrypt() throws Exception {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    boolean success = false;
    try {
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        //read the file into memory
        fis = new FileInputStream(from);
        fos = new FileOutputStream(to);
        byte[] inBytes = new byte[50 * 1024];
        int count;
        while ((count = fis.read(inBytes)) > 0) {
            byte encrypted[] = cipher.update(inBytes, 0, count);
            fos.write(encrypted);
        }
        byte encrypted[] = cipher.doFinal();
        fos.write(encrypted);
        fos.flush(); // redundant, since closing the stream will flush it.
        success = true;
    } catch (InvalidKeyException ivke) {
        ivke.printStackTrace();
        trouble = true;
    } finally {
        if (fis != null) fis.close();
        if (fos != null) fos.close();
    }
    //return Base64.encodeBase64String(encrypted);
    return success;
}

public boolean decrypt() throws Exception {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    boolean success = false;
    try {
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        //read the file into memory
        fis = new FileInputStream(from);
        fos = new FileOutputStream(to);
        byte[] inBytes = new byte[50 * 1024];
        int count;
        while ((count = fis.read(inBytes)) > 0) {
            byte decrypted[] = cipher.update(inBytes, 0, count);
            fos.write(decrypted);
        }
        byte decrypted[] = cipher.doFinal();
        fos.write(decrypted);
        fos.flush();
        success = true;
    } catch (InvalidKeyException ivke) {
        trouble = true;
        ivke.printStackTrace();
    } finally {
        if (fis != null) fis.close();
        if (fos != null) fos.close();
    }
    //return Base64.encodeBase64String(encrypted);
    return success;
}