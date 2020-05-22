public class Gold {

    public static final int TOTAL_RESERVES = 100;

    private int weight;

    private static int remainingWeight;

    static {
        remainingWeight = TOTAL_RESERVES;
    }

    public Gold(int weight) {

        if (remainingWeight <= 0) {

            this.weight = 0;
            remainingWeight = 0;
        }

        else {
            if (weight >= 0) {
                if (weight > remaining())
                    this.weight = remaining();
                else
                    this.weight = weight;
            } else {
                this.weight = 0;
            }

            remainingWeight -= this.weight;
        }
    }

    public int getWeight() {
        return this.weight;
    }

    public static int remaining() {
        return remainingWeight;
    }

    @Override
    public String toString() {
        return "Weight = " + this.weight;
    }

    public static void main(String[] args) {

    }
}