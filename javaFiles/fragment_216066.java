public class ArrayLists {
  public static void main(String[] args) {
    int n = 23987443;
    int pow = Integer.highestOneBit(n);
    int l = n - pow;
    System.out.println("Winner:[" +((2*l)+1)+"]" );
  }
}