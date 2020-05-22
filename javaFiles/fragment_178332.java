InputStream in = new FileInputStream("path-to-file");
    KeyGenerator keygen = KeyGenerator.getInstance("AES");
    Key key = keygen.generateKey();

    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    PipedOutputStream pout = new PipedOutputStream();
    //write data in a separate thread.
    new Thread(() -> {
        try(CipherOutputStream out = new CipherOutputStream(
                pout, cipher))
        {
            byte[] buffer = new byte[8192];
            int count;
            while ((count = in.read(buffer)) > 0)
            {
                out.write(buffer, 0, count);
            }
        } catch (IOException  e)
        {
            e.printStackTrace();
        }
    }).start();

    return new PipedInputStream(pout);