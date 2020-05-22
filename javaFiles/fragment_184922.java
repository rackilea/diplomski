public abstract class  LegacyMyClassMixIn{
    @JsonProperty("name")
    private String name;
    @JsonGetter("name")
    public abstract String getName();
    @JsonSetter("name2")
    public abstract void setName(String name) ;
}