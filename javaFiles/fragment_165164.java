class C {
  // snip

  /**
   * JAXB only
   */
  @SuppressWarnings("unused")
  @XmlElement
  private void setT1(int t1) {
    if(t != null) {
      t.setT1(t1);
    } else {
      // TODO
    }
  }

  /**
   * JAXB only
   */
  @SuppressWarnings("unused")
  private int getT1() {
    if(t != null) {
      return t.getT1(t1);
    } else {
      // TODO
    }
  }
}