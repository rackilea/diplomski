public class LargestEven {
  int largestEven(int x, int y, int z) {
    boolean xIsEven = x%2 == 0;
    boolean yIsEven = y%2 == 0;
    boolean zIsEven = z%2 == 0;
    //checks that x is even and greater from y and z if y and z are
    //even respectively
    if (xIsEven && (!yIsEven || x>=y) && (!zIsEven || x >= z)) {
      return x; // this part won't return
    }
    //we know for sure that x is not the largest even
    //so we skip checking it
    if (yIsEven && (!zIsEven || y>=z)) {
      return y;
    }
    //we know that neither x or y are the largest evens
    //so return either z if z is even, or 0
    return zIsEven ? z : 0;
  }
}