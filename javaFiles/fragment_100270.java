private static Scanner k = new Scanner (System.in);
public static void main(String[] args) {
  int min=getNumber(false);
  for (int count=1; count<10; count++) {
    int y=getNumber(true);
    if(y<min&&y>=0)
      min=y;
  }
  System.out.println(min);
}
private static int getNumber(boolean allowNegative) {
  System.out.println("Please enter an integer:");
  int n=0;
  try {
    n=Integer.parseInt(k.nextLine());
  } catch(NumberFormatException nfe) {
    System.err.println("Input must be an integer...");
    return getNumber(allowNegative);
  }
  if(allowNegative) {
    return n;
  } else {
    if(n<0) {
      System.out.println("You cannot start with a negative number...");
      return getNumber(allowNegative);
    } else {
      return n;
    }
  }
}