public class JacksonInheritanceTest2 {

    @Test
    public void deserializeChildrenAsGrandParentList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String grandparentsJson = "{" +
                "\"list\":[{" +
                "\"type\": \"child\"," +
                "\"someProperty\": \"foobar\"" +
                "}]" +
                "}";
        GrandParentList grandparents = mapper.readValue(grandparentsJson, GrandParentList.class);
        Assertions.assertNotNull(grandparents);
    }


}

class GrandParentList {
    @JsonProperty
    List<GrandParent> list;
}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Parent.class,name = "parent"),
        //@JsonSubTypes.Type(value = Child.class, name = "child")
})
class GrandParent {
    @JsonProperty("type")
    private String type;

}


//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Child.class, name = "child")
})
class Parent extends GrandParent {
    @JsonProperty
    private String value;

}

@JsonSubTypes({
    @JsonSubTypes.Type(value = Child.class, name = "child")
})
class Child extends Parent {
    @JsonProperty
    private String someProperty;

    public String getSomeProperty() {
        return someProperty;
    }

    public void setSomeProperty(String someProperty) {
        this.someProperty = someProperty;
    }



}