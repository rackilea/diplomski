package maincalculator;
    //Imports the scanner that I will be using.
    import java.util.Scanner;
    /**
     *
     * @author alex
     */
    public class MainCalculator {
         //Public static void for the class.
        public static void main(String[] args) {
            //Welcome print at the start of application.
            System.out.println("Welcome to the Calculator V1.O");
            //Blank line seperator.
            System.out.println("");
            System.out.println("What would you like to do today?");
            System.out.println("");
            //The options that will be shown to the program user in the console.
            //Option List for the program.
          System.out.println("1. Add");
          System.out.println("2. Subtract");
          System.out.println("3. Divide");
          System.out.println("4. Multiply");
          //Scans for the selected option.
          //Creates a new scanner.
          Scanner scan = new Scanner(System.in);
          //Checks if the next integer is selected.
          //Variables set to load the functions of each calculator.
          //Scans the integer choices.
          int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Add.addcode();
                    break;
                case 2:
                    Sub.subcode();
                    break;
                case 3:
                   Div.divcode();
                    break;
                case 4:
                    Multi.multicode();
                    break;
                default:
                    //Print this line if 1-4 are not selected.
                    System.out.println("Option Unavailable");
                    break;
            }
        }
    }
     class Add {
         public static void addcode (){ 
         //Input a new scanner.
         Scanner input = new Scanner( System.in ); 
         //Collects the data from number1 and number2.
         int number1; 
         int number2; 
         int sum; 
         //Menu name
         System.out.println( "Add" );
         //Creates the message for the first number.
         System.out.print( "Enter your first number: " ); 
         //Creates the message for the second nmber.
         number1 = input.nextInt(); //Defines number1 
         System.out.print( "Enter your second number: " ); 
         number2 = input.nextInt(); //Defines number2 
         //Use addition symbol between the two numbers.
         sum = number1 + number2; 
         System.out.printf( "Sum equals %d\n", sum); 
        }
    }

     class Sub {
       public static void subcode (){ 
       Scanner input = new Scanner( System.in ); 
         int number1; 
         int number2; 
         int sum; 
     System.out.println( "Subtraction" );
         System.out.print( "Enter your first number: " ); 
         number1 = input.nextInt(); //Defines number1 
         System.out.print( "Enter your second number: " ); 
         number2 = input.nextInt(); //Defines number2 

         sum = number1 - number2; 
         System.out.printf( "Sum equals %d\n", sum);  
        } 
    }

    class Div {
       public static void divcode (){ 
       Scanner input = new Scanner( System.in ); 
         int number1; 
         int number2; 
         int sum; 

         System.out.println( "Division" );
         System.out.print( "Enter your first number: " ); 
         number1 = input.nextInt(); //Defines number1 
         System.out.print( "Enter your second number: " ); 
         number2 = input.nextInt(); //Defines number2 

         sum = number1 / number2; 
         System.out.printf( "Sum equals %d\n", sum);  
         }
    }

    class Multi {
        public static   void multicode (){ 
        //Multiplication
        //New scanner.
        Scanner input = new Scanner( System.in ); 
        //Int number from below.
         int number1; 
         int number2; 
         //The sum answer displayed.
         int sum; 

         System.out.println( "Multiply" );
         System.out.print( "Enter your first number: " ); 
         number1 = input.nextInt(); //Defines number1 
         System.out.print( "Enter your second number: " ); 
         number2 = input.nextInt(); //Defines number2 
         sum = number1 * number2; 
         System.out.printf( "Sum equals %d\n", sum);  
        }
      }