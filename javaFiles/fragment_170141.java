public static  void main(String... args) throws Exception {

    String testJson = "{\"18\":{\"name\":\"poomba\",\"value\":\"topchoomba\"}}";

    Gson gson = new GsonBuilder().create();

    MyClassFor18 test18 = gson.fromJson(testJson, MyClassFor18.class);

    System.out.println(test18);

}

private static class MyClassFor18 {

    @SerializedName ("18")
    private TestPojo valueObject;

    public TestPojo getValueObject() {
        return valueObject;
    }

    public void setValueObject(TestPojo valueObject) {
        this.valueObject = valueObject;
    }

    @Override
    public String toString() {

        return "MyClassFor18 (value=" + valueObject + ")";
    }

}
private static class TestPojo {

    private String name;
    private String value;

    public TestPojo(String name, String value) {

        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return "TestPojo { name=" + this.name + ", value=" + this.value
                + "}";
    }
}