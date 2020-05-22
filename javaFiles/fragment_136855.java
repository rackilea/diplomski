try (InputStream in = new BufferedInputStream(new FileInputStream(f))) {
    int len;
    byte[] temp = new byte[300];
    while ((len = in.read(temp)) > 0)
        System.out.println(Base64.encode(temp, 0, len));
}