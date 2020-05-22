InputStream in = new FileInputStream("path-to-file");
    KeyGenerator keygen = KeyGenerator.getInstance("AES");
    Key key = keygen.generateKey();

    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    try(CipherOutputStream out = new CipherOutputStream(
            new FileOutputStream(new File("path to enc file")), cipher))
    {
        byte[] buffer = new byte[8192];
        int count;
        while ((count = in.read(buffer)) > 0)
        {
            out.write(buffer, 0, count);
        }
    }

    return new FileInputStream(new File("path to enc file"));