private ObjectMapper om;

@Before
public void setUp() throws Exception {
    om = new ObjectMapper();
    // disable auto detection
    om.disable(MapperFeature.AUTO_DETECT_CREATORS,
            MapperFeature.AUTO_DETECT_FIELDS,
            MapperFeature.AUTO_DETECT_GETTERS,
            MapperFeature.AUTO_DETECT_IS_GETTERS);
    // if you want to prevent an exception when classes have no annotated properties
    om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
}

@Test
public void test() throws Exception {
    BlahClass blahClass = new BlahClass(5, "email", true);
    String s = om.writeValueAsString(blahClass);
    System.out.println(s);
}

public static class BlahClass {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("email")
    public String email;
    public boolean isThing;

    public BlahClass(Integer id, String email, boolean thing) {
        this.id = id;
        this.email = email;
        isThing = thing;
    }
}