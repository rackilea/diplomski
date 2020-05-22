public class Utility <T extends DataType> { // or <T implements DataTypeable>

    private T d;

    public Utility(T d) {
        this.d = d;
    }

    public int getValue() {
        return d.getInt();
    }
}