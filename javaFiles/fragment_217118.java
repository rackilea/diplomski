import java.util.Scanner;

public class Temperature{

   public static void main(String[] args) {  // Main Method//

       Scanner input = new Scanner(System.in);

    //Declare variables
       int choice; // the user's choice in the menu //
       int temp;   

       do   {

            // print the menu

               System.out.println("1.fahrenheit to Celsius"); 
               System.out.println("2.Celsius to Fahrenheit"); 
               System.out.println("3.Exit"); 
               System.out.println(""); 
               System.out.println("Choice:");

            choice = input.nextInt();


            if  ( choice != 3 ) {

              System.out.print( "Enter temperature: " ); // Display Enter Temperature
              temp = input.nextInt();  // Read Temperature


              if (choice == 1) {

                  System.out.println( temp +  " Fahrenheit is " + toCelsius( temp ) +" Celsius ");
                  System.out.println("");
              }

              else if (choice == 2 ) {
                  System.out.println(temp + " Celsius is " +  toFahrenheit( temp ) + " Fahrenheit ");
                  System.out.println("");

              } 

            }
            else {
             System.out.println("Program terminated ");   //  Display "Program terminated" if user entered 3
           }//end else loop

       } // end do loop
       while (choice !=3);

   }  // end main method



// return Celsius equivalent of Fahrenheit temperature
   public static int    toCelsius(int  fahrenheit) {
       int   celsius;
       celsius = (int) (5.0/9.0 * (fahrenheit - 32));
        return celsius;
   }  // end method celsius


     // return Fahrenheit equivalent of Celsius temperature
     public static int    toFahrenheit(int  celsius) {
         int   fahrenheit;
          fahrenheit = (int) (9.0/5.0 * celsius + 32);
         return fahrenheit;
       } // end method fahrenheit

  }