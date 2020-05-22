public static void main(String[] args) {
    ByteArrayInputStream in = new ByteArrayInputStream("abc".getBytes());
    int value;
    while ((value = in.read()) > -1) {
        System.out.println((char) value);
    }
}