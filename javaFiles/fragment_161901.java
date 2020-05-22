class MyIncrementor {
  int myCount;
  boolean valueSet = false; //line changed - just to show that by default it is initialized to false

  /**
   * @return the myCount
   */
  public synchronized int getMyCount() {
    while (!valueSet) { //corrected as advised in comments, see @Tom Hawtin - tackline answer for details
      try {
        wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    System.out.println("get" + myCount);
    valueSet = false; //line changed - after getting the value set flag to false
    notifyAll();
    return myCount;
  }

  /**
   * @param myCount
   *            the myCount to set
   */
  public synchronized void setMyCount(int myCount) {
    while (valueSet) { //corrected as advised in comments, see @Tom Hawtin - tackline answer for details
      try {
        wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    System.out.println("Set" + myCount);
    this.myCount = myCount;
    valueSet = true; //line changed - after setting the value set flag to true
    notifyAll();
  }

}