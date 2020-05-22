class Dog {
    static String mSize[] = { "tiny", "small", "average", "large" };
    int dogSize = 0;
    int meals = 0;

    void feed() {
        if (++meals % 3 == 0) {
            dogSize++;
        }
    }

    @Override
    public String toString() {
        return String.format("Weight = %.2f, Meals = %d, Size = %s",
                meals / 3.0, meals, mSize[dogSize]);
    }
}