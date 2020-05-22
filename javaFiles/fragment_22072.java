public void saveReport(KmaxWidget widget)
    throws IOException
{
    final String content = report.getProperty("TEXT");
    final Path path = Paths.get("logKMAX.txt");

    try (
        final BufferedWriter writer = Files.newBufferedWriter(path,
            StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    ) {
        writer.write(content);
        writer.flush();
    }
}