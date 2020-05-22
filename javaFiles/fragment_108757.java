package Sample;

import java.util.ArrayList;
import java.util.Scanner;

public class tets 
{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int menuItem = 0;
        do {
            System.out.println("Choose menu item 1,2,3,4,5: ");
            try 
            {
                menuItem = Integer.parseInt(in.nextLine());
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Wrong input, Please enter again");
                menuItem=0;
            }
        } while (menuItem <= 5 && menuItem >=0);
        System.out.println("You have entered no > 5 OR no < 0");
        System.out.println("EXIT");
        }   

}

OUTPUT:
Choose menu item 1,2,3,4,5: 
2
Choose menu item 1,2,3,4,5: 
4
Choose menu item 1,2,3,4,5: 
A
Wrong input, Please enter again
Choose menu item 1,2,3,4,5: 
-1
Choose menu item 1,2,3,4,5: 
6
You have entered no > 5 OR no < 0
EXIT