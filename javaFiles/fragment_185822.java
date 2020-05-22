package forum12914382;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyFieldAdapter extends XmlAdapter<MyFieldAdapter.AdaptedMyField, String> {

    @Override
    public String unmarshal(AdaptedMyField v) throws Exception {
        return v.value;
    }

    @Override
    public AdaptedMyField marshal(String v) throws Exception {
        AdaptedMyField amf = new AdaptedMyField();
        amf.value = v;
        return amf;
    }

    public static class AdaptedMyField {

        @XmlAttribute
        public String value;

    }

}