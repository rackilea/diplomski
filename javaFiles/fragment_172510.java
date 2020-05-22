import java.util.Scanner;

public class MultipleLooping{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int integer,numberMultiples;

        System.out.println("Enter an integer: ");
        integer = keyboard.nextInt();

        System.out.println("How many multiples of " + integer + " would you like to know?");
        numberMultiples = keyboard.nextInt();

        for (int i=1; i<=numberMultiples; i++){
            System.out.println("Listing multiple N# " + i + "   =  "+ i*integer );
        }
    }
}


Enter an integer: 
3
How many multiples of 3 would you like to know?
7
Listing multiple N# 1   =  3
Listing multiple N# 2   =  6
Listing multiple N# 3   =  9
Listing multiple N# 4   =  12
Listing multiple N# 5   =  15
Listing multiple N# 6   =  18
Listing multiple N# 7   =  21