import javax.xml.bind.annotation.adapters.XmlAdapter;

public class NameAdapter extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String string) throws Exception {
        return string;
    }

    @Override
    public String marshal(String string) throws Exception {
       if("test10".equals(string) {
           return null;
       }
       return string;
    }

}