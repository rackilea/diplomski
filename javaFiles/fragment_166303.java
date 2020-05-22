resourceConfig.register(JerseyPropertiesFeature.class);
resourceConfig.property(JerseyPropertiesFeature.RESOURCE_PATH, "appication.properties");

@Path("test")
public class SomeResource {

    @Prop("some.prop")
    private String someFieldProp;

    private String someConstructorProp;

    public SomeResource(@Prop("some.prop") String someConstructorProp) {
        this.someConstructorProp = someConstructorProp;
    }

    @GET
    public String get(@Prop("some.prop") String someParamProp) {
        return someParamProp;
    }
}