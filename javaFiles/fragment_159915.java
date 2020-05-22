package forum10075634;

import java.util.Map;

public class SampleClassA extends DelegatedMap<String, Object> {

    public SampleClassA() {
        super();
    }

    public SampleClassA(Map<String, Object> m) {
        super(m);
    }

    public void setSomeProperty(String value) {
        put("somevalue", value);
    }

    public String getSomeProperty() {
        return (String) get("somevalue");
    }

}