public class ArrayManip
 {
  public static void main(String [] args)
  {
    int numbers [] = {2,3,4,5,6,6,5,4,3,2};
    boolean areThey = valuesSymmetrical(numbers);

    System.out.println(areThey );

  }

  public static boolean valuesSymmetrical(int [] n)
  {
    int i = 0, j = n.length - 1;  // notice here you had y and not j!
    while (n[i] == n[j] && i < j)
    {
      i++;
      j--;
    }

    if (i < j) return true;
    else return false;
  }
}