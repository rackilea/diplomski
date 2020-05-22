public static void main(String[] args) throws IOException, ClassNotFoundException {

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutput out = null;
    byte[] bytes;

    String content = "Hello Java Code Geeks";

    out = new ObjectOutputStream(bos);
    out.writeObject(content);
    out.flush();
    bytes = bos.toByteArray();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    outputStream.write(bytes);

    System.out.println(Arrays.toString(outputStream.toByteArray()));
    System.out.println(outputStream.toString());
    // correct string printed out
    System.out.println(new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray())).readObject());

}