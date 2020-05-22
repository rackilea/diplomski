public class Welcome { // Names changed to be more conventional
    private final int[] values;

    public Welcome(int... values) {
        this.values = values;
    }

    public void printValues() {
        for (int value : values) {
            System.out.println(value);
        }
    }
}