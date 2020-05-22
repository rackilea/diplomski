public class DataHolder {
    @JsonSerialize(using = BytesToStringSerializer.class)
    byte[] expectedData;

    public DataHolder(byte[] expectedData) {
        this.expectedData = expectedData;
    }
}