public class Wrapper {
    private final String value;

    public Wrapper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // I personally prefer to use a custom cell renderer, but 
    // for the sake of brevity, I'm using the toString method instead
    @Override
    public String toString() {
        return value;
    }

}