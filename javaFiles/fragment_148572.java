public enum Card {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

    private int value;

    Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Card getPrevious() {
        int previous = ordinal() - 1;
        if (previous < 0 ) { // if negative, then we have to go to the last element
            previous += values().length;
        }

        return Card.values()[previous];
    }
}