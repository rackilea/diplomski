public class YamlEntity {
    private Map<String, List<String>> value;

    public Map<String, List<String>> getValue() {
        return value;
    }

    public void setValue(Map<String, List<String>> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "YamlEntity [value=" + value + "]";
    }

 }