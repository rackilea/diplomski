public class A {
    private String a1;
    private Integer a2;
    public String getA1() { return a1; }
    public Integer getA2() { return a2; }
    public void setA1(String a1) { this.a1 = a1; }
    public void setA2(Integer a2) { this.a2 = a2; }

    @JsonCreator
    public static A fromJSON(String val) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        A a = mapper.readValue(val,A.class);
        return a;
    }
}