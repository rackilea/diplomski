import java.util.Random;

public class Die {

    private int mSides;
    private Random mRandom;

    public Die(int sides) {
        this.mSides = sides;
        mRandom = new Random(System.currentTimeMillis());
    }

    public int roll() {
        return mRandom.nextInt(mSides + 1);
    }

    public int roll(int times) {
        int sum = 0;
        for (int i = 0; i < times; i++) {
            sum += roll();
        }
        return sum;
    }
}