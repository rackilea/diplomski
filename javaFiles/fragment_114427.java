public static void main(String[] args) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);
    dos.writeByte(-128);
    dos.writeByte(-128 + 256);
    System.out.println(Arrays.toString(baos.toByteArray()));
}