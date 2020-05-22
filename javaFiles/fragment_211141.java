public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    while (sb.length() < 751396)
        sb.append("Size: ").append(sb.length()).append("\n");
    String s = sb.toString();

    String s2 = deflateBase64(s);
    System.out.println("Uncompressed size = " + s.length() + ", compressed size=" + s2.length());

    String s3 = inflateBase64(s2);
    System.out.println("Same after inflating is " + s3.equals(s));
}

public static String deflateBase64(String text) {
    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (Writer writer = new OutputStreamWriter(new DeflaterOutputStream(baos))) {
            writer.write(text);
        }
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    } catch (IOException e) {
        throw new AssertionError(e);
    }
}

public static String inflateBase64(String base64) {
    try (Reader reader = new InputStreamReader(
            new InflaterInputStream(
                    new ByteArrayInputStream(
                            Base64.getDecoder().decode(base64))))) {
        StringWriter sw = new StringWriter();
        char[] chars = new char[1024];
        for (int len; (len = reader.read(chars)) > 0; )
            sw.write(chars, 0, len);
        return sw.toString();
    } catch (IOException e) {
        throw new AssertionError(e);
    }
}