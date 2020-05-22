package forum8807296;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BarAdapter extends XmlAdapter<Object, Bar<?>> {

    @Override
    public Bar<?> unmarshal(Object v) throws Exception {
        if(null == v) {
            return null;
        }
        Bar<Object> bar = new Bar<Object>();
        bar.setValue(v);
        return bar;
    }

    @Override
    public Object marshal(Bar<?> v) throws Exception {
        if(null == v) {
            return null;
        }
        return v.getValue();
    }

}