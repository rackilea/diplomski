public class Item {
    private String id;
    private String label;
    private String code;

    @Override
    public String toString() {
        return "[" + id + ", " + label + ", " + code + "]";
    }

    // getters, setters...
}