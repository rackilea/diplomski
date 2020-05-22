public class Test {
    private int num;

    public Test(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.format("Test %d", this.num); // Override the toString() method
    }
}