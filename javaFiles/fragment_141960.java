public enum Animal {
    FOX(4, CHICKEN),    // 'CHICKEN' doesn't exist yet
    WORM(0, null),
    CHICKEN(2, WORM);    // this actually will compile

    private int countLegs;
    private Animal eatsWhat;

    Animal(int n, Animal dinner) {
        countLegs = n;
        eatsWhat = dinner;
    }

    public int getLegCount() {
        return countLegs;
    }
    // .. getters, setters, etc
}