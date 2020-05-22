public class Bean implements Serializable {
    String name;
    float value;

    public Bean(String name, float newValue) {
        this.name   = name;
        this.value = newValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float newValue) {
        this.value = newValue;
    }
}