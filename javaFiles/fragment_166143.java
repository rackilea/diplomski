public class ObjBuilder {
    private String a;
    private String b;
    private List<KeyValue> keyValues = new ArrayList<>();

    private ObjBuilder() {}

    public static ObjBuilder obj() {
        return new ObjBuilder();
    }

    public ObjBuilder withA(String a) {
        this.a = a;
        return this;
    }

    public ObjBuilder withB(String b) {
        this.b = b;
        return this;
    }

    public ObjBuilder withKeyValue(KeyValue keyValue) {
        this.keyValues.add(keyValue);
        return this;
    }

    public Obj build() {
        // whatever Obj.makeSomeObject does to create the Obj instance
    }
}