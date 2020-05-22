public class DataRecord {
    [.....]
    private String TUN; 

    @Override
    public boolean equals(Object o) {
        if (o instanceof DataRecord) {
            DataRecord that = (DataRecord) o;
            return Objects.equals(this.TUN, that.TUN);
        }
        return false;
    }

    @Override
    public int hashCode() {
           return Objects.hashCode(TUN);
    }
}