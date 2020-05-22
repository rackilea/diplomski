public static void main(String[] args) throws IOException {
    List<OutputStream> files = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
        files.add(Files.newOutputStream(Paths.get("/tmp/demo." + i), 
                StandardOpenOption.CREATE));
    }
}