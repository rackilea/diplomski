public class Wrapper<T> {
    private String key;
    private T value;
    @JsonAnySetter
    public void set(String key, Object value) {
        this.key = key;
        this.value = (T)value;
    }
    public String toString() {  // just for nice printing
        return key + "=" + value.toString();
    }
}