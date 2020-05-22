public class Pair {
  public int left;
  public int right;

  Pair(int left, int right) {
    this.left = left;
    this.right = right;
  }

  public boolean equals(Object otherObj) {
    if (otherObj == null || !(otherObj instanceof Pair)) {
      return false;
    }
    Pair otherPair = (Pair) otherObj;
    return (this.left == otherPair.left && this.right == otherPair.right);
  }
  public int hashCode() {
    return new Integer(this.left).hashCode() + new Integer(this.right).hashCode();
  }
}