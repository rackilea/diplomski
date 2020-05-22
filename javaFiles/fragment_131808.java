public Fraction negate()
{
    int num = this.numerator * -1;
    int den = this.denominator;
    return new Fraction(num,den);
}