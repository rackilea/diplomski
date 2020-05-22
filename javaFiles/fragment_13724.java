public class SetCoefProvider {
  private String[] set;
  private double[] coef;

  public SetCoefProvider(String[] set, double[] coef) {
    this.set  = set;
    this.coef = coef;
  }

  public String[] getSet() {
    return set;
  }
  public double[] getCoef() {
    return coef;
  }
}

public class SetCoefProviderFactory {
  public static SetCoefProvider createObj1Provider() {
    return new SetCoefProvider(new String[] {"a", "b", "c"}, new double[] {1,2,3});
  }
  public static SetCoefProvider createObj2Provider() {
    return new SetCoefProvider(new String[] {"x", "y", "z"}, new double[] {11,12,13});
  }
}