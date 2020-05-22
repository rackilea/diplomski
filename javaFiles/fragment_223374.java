public class SomeBean {

    private String data;

    @NotEmpty
    public String getData() { return data; }

    public void setData(@NotEmpty String data) { this.data = data; }

}