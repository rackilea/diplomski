@XmlElement(name = "CHILD1")
@XmlJavaTypeAdapter(ValueAdapter.class)
private String child1;

public class ValueAdapter extends XmlAdapter<Object, String> {
    private static String VALUE = "VALUE";
    @Override
    public String unmarshal(Object e) throws Exception {
        if (e instanceof ElementNSImpl && ((ElementNSImpl)e).hasAttribute(VALUE)) {
            return ((ElementNSImpl)e).getAttribute(VALUE);
        }
        return null;
    }

    @Override
    public Object marshal(String s) throws Exception {
        return null;
    }
}