public static void main(String[] args) {
    //Create a Rational with an empty constructor
    Rational r1 = new Rational();
    int numerator = 1, denominator = 2; 
    //Create a Rational with an the second constructor that take two int
    Rational r2 = new Rational(numerator, denominator);
    //then you can use your methods like this.
    r2.gcd(numerator, numerator);
}