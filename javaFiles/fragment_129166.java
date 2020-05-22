package calculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calc {

    public static void main(String[] args) {



        Scanner equationScan = null;
        int count;
        double a=0;
        double b=0;
        double calc1;

        try { //optional: add a try catch block to catch FileNotFoundException exception
            equationScan = new Scanner(new File("calculator.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        count = equationScan.nextInt();
        equationScan.nextLine();    //add a nextline() according to what TOM pointed

        while(count > 0)
        {
            String line = equationScan.nextLine();

            if(line.equals("sin"))
            {
                String value=equationScan.nextLine(); //Parse the double to a string
                a=Double.parseDouble(value);

                calc1 = Math.sin(a) ; //Assignment should be at the right sign of the = operator
            }
        }


    }
}