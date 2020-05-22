public enum EnumWithMethod {

  VALUE_A {
    @Override
    public String enumMethod(String s) {
      return s + "-A";
    }
  },
  VALUE_B{
    @Override
    public String enumMethod(String s) {
      return s + "-B";
    }
  };

  public abstract String enumMethod(String s);

}