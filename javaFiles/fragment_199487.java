public class CustomHeaderWriter implements FlatFileHeaderCallback {

    private String header;

    @Override
    public void writeHeader(Writer writer) throws IOException {
        writer.write(header);
    }

    public void setHeader(String header) {
        this.header = header;
    }
}