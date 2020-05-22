public static void main(String... args) throws IOException {
    System.out.println("01 => " + Arrays.toString(byteValues("01")));
    System.out.println("0001 => " + Arrays.toString(byteValues("0001")));
    System.out.println("0123456789ABCDEF => " + Arrays.toString(byteValues("0123456789ABCDEF")));
}

public static byte[] byteValues(String text) {
    byte[] bytes = new byte[text.length()];
    for(int i=0;i<text.length();i++)
        bytes[i] = (byte) Character.getNumericValue(text.charAt(i));
    return bytes;
}