public static byte[] loadBytesForClass(ClassLoader loader, String fqn) throws IOException {
    InputStream input = loader.getResourceAsStream(fqn.replace(".", "/") + ".class");
    if (input == null) {
        System.out.println("Could not load bytes for class: " + fqn);
    }
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    StringUtil.copy(input, output);
    return output.toByteArray();
}