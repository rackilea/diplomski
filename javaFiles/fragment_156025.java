public class Foo implements Serializable {

    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Foo [value=" + value + "]";
    }

}