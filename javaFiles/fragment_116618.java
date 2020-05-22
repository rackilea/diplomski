private String someProperty;

@Value("${some.property}")
public void setSomeProperty(String someProperty) {
    this.someProperty = someProperty;
}