import java.util.Scanner;
class stack1
{
  public static void main (String[] args) 
  {
  int q1=0 , q2 , q3, q4, q5, q6 , q7 ,q8 ,q9 ,q10 , a ;
  boolean correct = false;
  char yn1='Y';

        Scanner input1 = new Scanner( System.in );

        int count = 0 ;
       while (correct == false) 
                { 
        System.out.println("What is 2+2? ");
        System.out.println("Choices:  0,2,4,8");
        q1 = input1.nextInt(); //used after loop


                System.out.println("Are You Sure? (Y/N)");
                char c = input1.next().charAt(0);              // Changed LINE
                if (c=='y')                                    // Changed LINE
                {
        System.out.println("Exiting the program");
               correct = true; //It should now stop the loop and carry on 
                     break;                        
                } 


                }


                if ( q1 == 4)  //q1 was stated during loop
                    System.out.println("You were correct 2+2 = 4");

                else

                    System.out.println("You were wrong");

              //Soon will add int score and add 1 each time its correct
              // will be using 9 more loops the exact same way



    }
  }