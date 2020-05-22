public static class MyWrapper {

  private int i;

  public MyWrapper(int i) {
    this.i = i;
  }

  public void setI(int i) {
    this.i = i;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return i == ((MyWrapper) o).i;
  }

  @Override
  public int hashCode() {
    return i;
  }
}