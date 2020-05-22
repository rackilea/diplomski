public class FacebookDataProvider implements DataProvider {
    public Data createData() {
        FacebookSpecificInfo x = ...

        FacebookData data = new FacebookData();

        // Note that this class does not know anything about foo, bar and baz.
        // We are still Facebook context.
        data.setName(x.getName());
        data.setValues(x.getValues());
        data.setHeaders(x.getHeaders());

        return data;
    }
}

class FacebookData implements Data {
    private String name;
    private List<String> values;
    private Map<String, Integer> headers;

    void setName(String name) { this.name = name; }
    void setValues(String values) { this.values = values; }
    void setHeaders(String headers) { this.headers = headers; }

    // This is the part where we switch the context and convert
    // Facebook specific data into our expected Data
    // ie. Facebook's name field corresponds my foo field.

    public String getFoo() { return name; }
    public List<String> getBar() { return values; }
    public Map<String, Integer> getBaz() { return headers; }
}