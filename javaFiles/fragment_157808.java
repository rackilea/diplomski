public class Example {

    @SerializedName("foo")
    @Expose
    private String foo;
    @SerializedName("bar")
    @Expose
    private String bar;
    @SerializedName("baz")
    @Expose
    private String baz;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String getBaz() {
        return baz;
    }

    public void setBaz(String baz) {
        this.baz = baz;
    }
}