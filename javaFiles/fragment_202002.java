InputStream in = new ByteArrayInputStream(new byte[]{
        0x00, 0x0a, (byte) 0xff,
        0x01, 0x01, 0x01, (byte) 0xff,
        0x01, (byte) 0xff});

ByteArrayOutputStream baos = new ByteArrayOutputStream();
for (int b; (b = in.read()) >= 0; ) {
    baos.write(b);
    if (b == 0xff) {
        byte[] bytes = baos.toByteArray();
        System.out.println(Arrays.toString(bytes));
        baos = new ByteArrayOutputStream();
    }
}