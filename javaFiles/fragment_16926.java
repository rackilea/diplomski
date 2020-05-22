public class Id implements FooItem {
    @XmlValue
    private String id;

    public Id() {}

    public Id(String id) {
        this.id = id;
    }
}