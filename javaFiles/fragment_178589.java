public class FArray {
  public static void main(String[] args) {
  int[] numbs = new int[10];
  for (int i = 0; i < numbs.length; i++) {
    numbs[i] = (int) (Math.random() * 100 + 1);
  }
  // print the values
  for (int i=0; i<numbs.length; i++) {
    System.out.println("the random number for element "+ i +" is "+numbs[i]);
  }
 }
}