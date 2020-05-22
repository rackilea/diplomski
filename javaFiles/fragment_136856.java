try (InputStream in = new BufferedInputStream(new FileInputStream(f))) {
    int len;
    byte[] temp = new byte[300];
    while ((len = in.read(temp)) > 0) {
        byte[] data;
        if (len == temp.length)
            data = temp;
        else {
            data = new byte[len];
            System.arraycopy(temp, 0, data, 0, len);
        }
        System.out.println(Base64.encode(data));
    }
}