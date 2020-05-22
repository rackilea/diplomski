public class EmptyTagAdapter extends XmlAdapter<String, String> {

    @Override
    public String marshal(String arg0) throws Exception {
        return arg0;
    }

    @Override
    public String unmarshal(String arg0) throws Exception {
       if(arg0.isEmpty()) {
           return null;
       }
        return arg0;
    }
}