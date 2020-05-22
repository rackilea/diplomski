import java.util.Scanner;

public class Carpenter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int orderNumber;
        String custName;
        String signType;
        int numOfCharacters;
        String color;
        int i = 20;
        double total;
        int counter;

//I changed the phrasing just because it is a little confusing
        System.out.println("Enter your number of orders");

        orderNumber = sc.nextInt();

        counter = orderNumber;

        sc.nextLine();

        System.out.println("Enter customer name");

        custName = sc.next();
        sc.nextLine();
//When you know how many times you want to repeat something (like when a user tells you how many) I prefer using a for-loop, a do while loop works as well though
        for(int x=0; x<counter;x++)
        {
            System.out.println("Enter the sign type (wood or plastic)");
            signType = sc.next();
//When comparing Strings, there is a function that you can use to compare them rather than using '=='          
// It is also good to use the 'equalsIgnoreCase()' function to be more user friendly and robust         

            if(signType.equalsIgnoreCase("wood")) {
                i+=10;
            }

            if(signType.equalsIgnoreCase("plastic")) {
                i+=5;
            }

//Flush the buffer (I haven't tested if this is necessary or not, it is good practice though)            
            sc.nextLine();
            System.out.println("Enter the number of characters");

            numOfCharacters = sc.nextInt();


            if(numOfCharacters > 5) {
                i += 2*(numOfCharacters-5);
            }

            System.out.println("Enter the color of characters");
            color = sc.next();

//Same concept as above, the differene is the ! before the function to test if it is false or not
            if(!color.equalsIgnoreCase("white") || !color.equalsIgnoreCase("black")) {
                i += 8;
            }
        }
            total =  i;
//You will not want to print this out until the end due to the possibility of it being over $100            
//          System.out.println("Total is: $" + total);
            if( total > 100 ) {
//Mathematically speaking, you are making your total a quarter of what the original is, rather than taking a quarter off. You want 75% rather than 25%
               // total = (total * 0.25);
                total = (total * 0.75);               
            }
            System.out.println("Total is: $" + total);
        }




}