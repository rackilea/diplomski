package pracset1;

import java.util.Scanner;

public class shortTall {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner keyboard = new Scanner(System.in);

        String name;
        String maxname = null;
        String minname = null;
        double height;
        double maxheight = -1.0d;
        double minheight = 1000.0d;
        char addperson;
        String choice;

        do
        {
            System.out.println("Enter first name of person");
            name = keyboard.next();
            System.out.println("Enter height of person");
            height = keyboard.nextDouble();

            while (height < 0.8 || height > 2.5)
            {
                System.out.println("Entered height must be above 0.8m and below 2.5m");
                height = keyboard.nextDouble();
            }

            if (height > maxheight)
            {
                maxheight = height;
                maxname = name;
            }

            if (height < minheight)
            {
                minheight = height;
                minname = name;
            }

            System.out.println("Do you want to add another person? (Y/N)");
            choice = keyboard.next();
            addperson = choice.charAt(0);
        }
        while (addperson == 'Y' || addperson == 'y');   // 

        System.out.println("Tallest person is " + maxname + " with a height of " + maxheight);
        System.out.println("Shortest person is " + minname + " with a height of " + minheight);

    }
}