public class Food {
    private String mstrName;
    private int mintCalories;

    public Food(String pstrName, int pintCalories) {
        mstrName = pstrName;
        mintCalories = pintCalories;
    }

    public String getName() {
        return mstrName;
    }

    public int getCalories() {
        return mintCalories;
    }

    public String toString() {
        return getName();
    }

}