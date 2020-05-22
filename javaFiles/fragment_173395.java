byte[] buffer;
try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
    bos.write("Hello World".getBytes(StandardCharsets.ISO_8859_1));
    buffer = bos.toByteArray();
    for (int i : buffer) {
        System.out.printf("%02X ", i & 0xFF);
    }
    System.out.println("");
}

try (ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
        ObjectInputStream ois = new ObjectInputStream(bis)) {
    String input = (String) ois.readObject();
    System.out.println("input: " + input);
}