static class GivenClass {

    private String name;
    private String location;
    private Integer age;

    public GivenClass(String name, String location, Integer age) {
        this.name = name;
        this.location = location;
        this.age = age;
    }

    public GivenClass(Map<String, Object> data) throws Exception {
        for (Field f : GivenClass.class.getDeclaredFields())
            f.set(this, data.get(f.getName()));
    }

    public Map<String, Object> serialize() throws Exception {
        Map<String, Object> fields = new HashMap<String, Object>();
        for (Field f : GivenClass.class.getDeclaredFields()) 
            fields.put(f.getName(), f.get(this));
        return fields;
    }

    @Override
    public String toString() {
        return "age=" + age + ", location=" + location + ", name=" + name;
    }
}