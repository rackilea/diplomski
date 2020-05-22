public interface MainIfc {
  public Hash getAttributes();
  public setAttributes(Hash attributes);
}

class Ifc1 implements MainIfc {
  private String a1;
  public String getA1() {
    return a1;
  }
  public void setA1(String a1) {
    this.a1 = a1;
  }
  public Hash getAttributes() {
    // return a hash with data that MainIfc consumer will need from this POJO
  }
  public setAttributes(Hash attributes) {
    // copy hash attributes to corresponding POJO fields
  }
}

class Ifc2 implements MainIfc {
  private String x1;
  private String x2;
  public String getX1() {
    return x1;
  }
  public void setX1(String x1) {
    this.x1 = x1;
  }
  public String getX2() {
    return x2;
  }
  public void setX2(String x2) {
    this.x2 = x2;
  }
  public Hash getAttributes() {
    // return a hash with data that MainIfc consumer will need from this POJO
  }
  public setAttributes(Hash attributes) {
    // copy hash attributes to corresponding POJO fields
  }
}