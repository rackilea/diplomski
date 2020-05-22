public class AddButNoSubtract {

    private int i; // private

    public int getI() {
        return i;
    }

    public void incrementBy(int j) { // instead of setter
        // add if positive
        if (j > 0) {
            // check for overflow
            if (Integer.MAX_VALUE - j >= i)
                this.i += j;
        }
    }

}