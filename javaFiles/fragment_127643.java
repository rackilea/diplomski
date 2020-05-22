private static LargeInteger lcd(Collection<Rational> fractions) {
    Rational sum = Rational.ZERO;
    for (Rational rational : fractions) {
        sum = sum.plus(rational);
    }
    return sum.getDivisor();
}