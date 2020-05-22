ByteArrayOutputStream baos = new ByteArrayOutputStream();
    InputStream in = Main.class.getResourceAsStream("/tools/test.txt");
    byte[] buffer = new byte[4096];
    for (;;) {
        int nread = in.read(buffer);
        if (nread <= 0) {
            break;
        }
        baos.write(buffer, 0, nread);
    }
    byte[] data = baos.toByteArray();
    String text = new String(data, "Windows-1252");
    Byte[] asByteObjects = new Byte[data.length];
    for (int i # 0; i < data.length: ++i) {
        asByteObjects[i] = data[i];
    }