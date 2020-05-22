public class KeyPressStats {
  private int leftCount = 0;
  private int rightCount = 0;

  public int getLeftCount() {
    return leftCount;
  }

  public void setLeftCount(int leftCount) {
    this.leftCount = leftCount;
  }

  public int getRightCount() {
    return rightCount;
  }

  public void setRightCount(int rightCount) {
    this.rightCount = rightCount;
  }

  public void incrementRight() {
    rightCount++;
  }

  public void incrementLeft() {
    leftCount++;
  }

}