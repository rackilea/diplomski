public class MyClass {
    private MyTypeSafeEnum someVar;

    @XmlJavaTypeAdapter(MyTypeSafeEnumXmlAdapter.class)
    public MyTypeSafeEnum getSomeVar() {
        return someVar;
    }
}