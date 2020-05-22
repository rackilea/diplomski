public static class SpellCard {

    private int index;

    private String name;

    ... // more fields here

    public SpellCard(int index, String name) {
        this.index = index;
        this.name = name;
        ... // more fields here.
    }

    // Copy constructor
    public SpellCard(SpellCard other) {
        this.index = other.index;
        this.name = other.name;
        ... // more fields here
    }
}