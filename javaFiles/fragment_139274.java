public int compareTo(Rational other) {
  //Should create copy constructor
    Rational num1 = new Rational(numerator, denominator);
    Rational num2 = new Rational(other.getNumerator(), other.getDenominator());
    num1.reduce();
    num2.reduce();

    if (num1.getDenominator() < num2.getDenominator()) {
      return -1;
    } else if (num1.getDenominator() == num2.getDenominator()) {
      if (num1.getNumerator() < num2.getNumerator()) {
        return -1;
      } else if (num1.getNumerator() > num2.getNumerator()) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return 1;
    }
  }