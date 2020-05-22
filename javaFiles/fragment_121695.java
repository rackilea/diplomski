public class A {
  private List<Integer> privateRef;
  private int privateVal = 0;

  public List<Integer> bad() {
      return this.privateRef;
  }

  public int good() {
      return privateVal;
  }

}