public class ResourceFileExtract {

    private String outputFile;
    private AtomicBoolean cancelled = new AtomicBoolean(false);

    public ResourceFileExtract(String outputFile) {
        this.outputFile = outputFile;
    }

    public void cancel() {
        cancelled.set(true);
    }

    public void extract() throws IOException {

        try (InputStream inputStream = getClass().getResourceAsStream("/resources/someFile");
                 OutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] bytes = new byte[1024];
            int numbers;
            while (!cancelled.get() && (numbers = inputStream.read(bytes)) > 1) {
                outputStream.write(bytes, 0, numbers);
            }
        } catch (IOException exp) {
            throw exp;
        }
    }
}