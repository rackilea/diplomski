class CMyType {
  private double var1;
  private double var2;

  public double get(String type) {
    if ( type.equals("var1") ) {
      return var1;
    } 
    if ( type.equals("var2") ) {
      return var2;
    }

    throw new IllegalArgumentException();
}