public class Stars {
  public static void main(String[] args) {
    printMoreStars(Integer.parseInt(args[0]));
  }

  public static  void printMoreStars (int n)
  {
    int rowsPrime= 0;

    for (int i = n+1; i > 0; i--)
    {
      for (int j = 0; j < (2*i)-1; j++)  
      {
        System.out.print(" ");
      }
      for (int d = 0; d < (2*rowsPrime)-1; d++)
      {
        System.out.print("*" + " ");
      }
      System.out.println();   //new line character

      rowsPrime +=1;
      System.out.println(" ");
    }

    rowsPrime -= 2; // <- middle line is already printed, so skip that

    //bottom triangle
    for (int i = 1; i < n+1; i++)
    {
      for (int j = 0; j < (2*i)+1; j++)  
      {
        System.out.print(" ");
      }
      for (int d = 0; d < (2*rowsPrime) - 1; d++) // <- changed condition to be the same as above
      {
        System.out.print("*" + " ");
      }
      System.out.println();   //new line character

      rowsPrime--; // <- you have to decrease rowPrime by one.
      System.out.println(" ");
    }
  }
}