public static class Wrapper<D> {
    // making fields public for simplicity, 
    // use public getters and private fields of course
    public Integer id;
    public String type;
    @JsonProperty("_data")
    public D  data;
}
public static class Person {
    // adding address field as a public int, 
    // same as above, encapsulate properly in real life
    public int address;
}