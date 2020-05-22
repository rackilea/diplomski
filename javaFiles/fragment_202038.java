public TheDie PassLine() {

    TheDie One = dieOne();
    TheDie Two = dieTwo();
    TheDie roll = rollTheDie();

    return new PassLine(One, Two, roll);
}