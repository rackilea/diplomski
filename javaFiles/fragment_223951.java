public class Utility {

    private DataType d;

    public Utility(DataType d) {
        this.d = d;
    }

    public int getValue() {
        return d.getInt();
    }
}