import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IdAdapter extends XmlAdapter<String, Integer> {

    @Override
    public Integer unmarshal(String string) throws Exception {
        return Integer.valueOf(string);
    }

    @Override
    public String marshal(Integer integer) throws Exception {
        if(integer == 0) {
            return null;
        }
        return String.valueOf(integer);
    }

}