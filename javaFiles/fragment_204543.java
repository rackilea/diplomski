public class Pair 
{

  private int left;
  private int right;

  public Pair(int left, int right) {
    // the following 2 lines don't do anything
    // it set's the argument "left = left" which is silly...

    left = left;
    right = right;

    // with the `this` keyword we can correctly initialize our class properties
    // and avoid name collision

    this.left = left;
    this.right = right;
  }

}