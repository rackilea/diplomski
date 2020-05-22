class CMyType {
  private Map<String, Double> vars = new HashMap();

  public CMyType() {
    vars.put("var1", 0.0);
    vars.put("var2", 0.0);
  }

  public double get(String type) {
    Double res = vars.get(type);
    if ( res == null ) throw new IllegalArgumentException();
    return res;
}