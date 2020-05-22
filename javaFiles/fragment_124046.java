import javax.xml.bind.annotation.XmlType;

@XmlType
public class KeyValue {
    public KeyValue() {
    }

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //obviously needs setters/getters
    String key;
    String value;
}