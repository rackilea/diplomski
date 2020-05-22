public static void main(String[] args) {

    String original = "US";
    int i = stringToInt(original);
    String copy = intToString(i);

    System.out.println("original: "+original);
    System.out.println("i: "+i);
    System.out.println("copy: "+copy);

}

static int stringToInt(String s) {

    byte[] bytes = s.getBytes();

    if (bytes.length > 4) {
        throw new IllegalArgumentException("String too large to be" +
                    " stored in an int");
    }

    byte[] fourBytes = new byte[4];
    System.arraycopy(bytes, 0, fourBytes, 0, bytes.length);

    try {
        return new DataInputStream(new ByteArrayInputStream(fourBytes))
                    .readInt();
    } catch (IOException e) {
        throw new RuntimeException("impossible");
    }
}

static String intToString(int i) {

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
        new DataOutputStream(byteArrayOutputStream).writeInt(i);
    } catch (IOException e) {
        throw new RuntimeException("impossible");
    }

    return new String(byteArrayOutputStream.toByteArray());
}