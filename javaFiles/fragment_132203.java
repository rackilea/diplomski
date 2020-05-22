public Polynomial2 divides(Polynomial2 b) {
    Polynomial2 a = this;
    if ((b.deg == 0) && (b.coef[0] == 0))
        throw new RuntimeException("Divide by zero polynomial"); //Zero polynomial is the one having coeff and degree both zero.

    if (a.deg < b.deg) return new Polynomial2(0,0);

    int coefficient = a.coef[a.deg]/(b.coef[b.deg]);
    int exponent = a.deg - b.deg;
    Polynomial2 c = new Polynomial2(coefficient, exponent);
    return c.plus( (a.minus(b.times(c)).divides(b)) );
}