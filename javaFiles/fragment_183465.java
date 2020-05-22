@Override
  public int compareTo(Rational o) {
    float mine = (float) getNumerator() / getDenominator();
    float other = (float) o.getNumerator() / o.getDenominator();
    return Float.compare(mine, other);
  }