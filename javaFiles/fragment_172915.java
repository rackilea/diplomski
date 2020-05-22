class Die 
{
    private int sides;

    private int value;

    public Die() {
        this.sides = 6;
    }           // default to six-sided die

    public Die(int sides) {
        this.sides = sides;
    }  // variable number of sides

    public void roll() {
        value = (int)(Math.random() * (sides-1)) + 1;
    }     // randomly picks a face value

    public int getValue() {
        return value;
    }  // returns the face value

}// end class Die