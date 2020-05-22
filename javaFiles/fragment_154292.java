import java.util.*;

public class Checker{

  public static void main(String[] args) {
    int col, row, size; char filler;
    System.out.println("Please enter 3 numbers and a character."); //output
    Scanner scan = new Scanner(System.in); //input

    row = scan.nextInt();
    col = scan.nextInt();
    size = scan.nextInt();
    filler = scan.next().charAt(0);  // defined variables

    int r,c,i=0,j=0,k=0;

    for (r=1; r<=row; r++) {
      do {
        for (c=1; c<=col; c++){
          if ((r % 2 != 0 && c % 2 !=0) || (r %2 == 0 && c % 2 == 0)){
            do {
              System.out.print(filler);
              i++;
            }
            while (i<size);
            i = 0;

          }


          else {
            do
            {  System.out.print(" ");
              j++;
            }
            while (j<size);
            j = 0;
          }
        }
        k++;
        System.out.println();
      }
      while (k < size);
      k = 0;
    }
    System.out.println("\nHave a nice day. Goodbye.");
  }

}