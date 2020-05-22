public enum Animal {
    FOX(4),
    CHICKEN(2),
    WORM(0);

    private int countLegs;

    Animal(int n) {
        countLegs = n;
    }

    public int getLegCount() {
        return countLegs;
    }
    // .. more getters setters etc
}