@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SuccessRestResponse<T> {

    private int code;
    private Map<String, T> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, T> getData() {
        return data;
    }

    @JsonIgnore
    public T getResult() {
        return data.get("result");
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }
}