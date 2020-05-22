public static void encrypt(File source, File dest, String password){
    try{
        FileInputStream inFile = new FileInputStream(source.getPath());
        OutputStream outFile = Base64.getEncoder().wrap(new FileOutputStream(dest.getPath()));

        byte[] salt = new byte[8], iv = new byte[16];

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKey secretKey = factory.generateSecret(keySpec);
        SecretKey secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret, new IvParameterSpec(iv));

        byte[] input = new byte[64];
        int bytesRead;

        while((bytesRead = inFile.read(input)) != -1){
            byte[] output = cipher.update(input, 0, bytesRead);
            if(output != null){
                outFile.write(output);
            }
        }

        byte[] output = cipher.doFinal();
        if(output != null){
            outFile.write(output);
        }

        inFile.close();
        outFile.flush();
        outFile.close();
    }catch(Exception e){
        e.printStackTrace();
    }
}

public static void decrypt(File source, File dest, String password){
    try{
        InputStream fis = Base64.getDecoder().wrap(new FileInputStream(source.getPath()));
        //FileInputStream fis = new FileInputStream(source.getPath());
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