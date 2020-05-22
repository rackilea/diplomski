public static void decrypt(File source, File dest, String password){
    try{
        Base64InputStream fis = new Base64InputStream(new DataInputStream(new FileInputStream(source.getPath())), Base64.DEFAULT);
        FileOutputStream fos = new FileOutputStream(dest.getPath());


        byte[] salt = new byte[8], iv = new byte[16];

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));

        byte[] in = new byte[64];
        int read;
        while((read = fis.read(in)) != -1){
            byte[] output = cipher.update(in, 0, read);
            if(output != null){
                fos.write(output);
            }
        }

        byte[] output = cipher.doFinal();
        if(output != null){
            fos.write(output);
        }
        fis.close();
        fos.flush();
        fos.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}