import java.util.*;

class tileFloor {

    public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner input = new Scanner (System.in);
    System.out.println("Enter x:");
        int x;
            x = input.nextInt();
   int count = 0;
    if (x < 10)
    { int c = 0;
      int r = 0;

      while (r < x ){
        if(r%2 == 0)
        {
            count = 0;
        }
        else
        {
            count = 1;
        }
          while (c < x ){


              if (count %2 == 0)
                {
                    System.out.print("|R");
                }
                else
                {
                    System.out.print("|B");
                }

            count++;
            c++;

          }//end 'while (c<x)' loop


            System.out.println("|");

        c = 0;
        r++;

       }//end 'while (r<x)' loop

    }//end if statement

    input.close();

}//end main

}//end class