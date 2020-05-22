interface Rational {    
  public int getNumerator();
  public int getDenominator();
  public Rational add(Rational other);
  public Rational multiply(Rational other);
  public int compareTo(Rational other);
}