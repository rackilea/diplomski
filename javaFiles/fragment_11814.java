import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

public class AdaptedOptions extends Options {

    @XmlAttribute String name;
    @XmlElement List<Value> value = new ArrayList<Value>();
    Map<String, String> map = new HashMap<String, String>();

    public void beforeMarshal(Marshaller marshaller) {
        for(Entry<String, String> entry : map.entrySet()) {
            Value aValue = new Value();
            aValue.name = entry.getKey();
            aValue.value = entry.getValue();
            value.add(aValue);
        }
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        for(Value aValue : value) {
            map.put(aValue.name, aValue.value);
        }
    }

    private static class Value {
        @XmlAttribute String name;
        @XmlValue String value;
    }

}