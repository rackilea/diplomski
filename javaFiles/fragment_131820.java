public class Pack {

    @JsonProperty("Info")
    private Info info;
    @JsonProperty("Data")
    private Data data;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("info", info).append("data", data).toString();
    }

}