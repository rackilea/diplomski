try (
    final BufferedWriter w = Files.newBufferedWriter(Paths.get(csvFile),
        StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    final PrintWriter writer = new PrintWriter(w);
) {
    for(int i = 0; i < A.size(); i++) {
        System.out.println(A.get(i)+", "+ B.get(i));
        writer.println(A.get(i)+", "+ B.get(i));
    }
    writer.flush();
}