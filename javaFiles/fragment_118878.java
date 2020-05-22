import java.math.BigInteger;
import java.util.Scanner;

public class BaseConversion {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String theValue;
        String result; 
        String newNum;
        int initialBase;
        int finalBase;
        String[] parts = args;
        if (parts.length > 0) {
            theValue = parts[0];
            isValidInteger(theValue);
            initialBase = Integer.parseInt(parts[1]);
            finalBase= Integer.parseInt(parts[2]);
            isValidBase(finalBase);
       }
       else {
            System.out.println("Please enter a value: ");
            theValue = s.nextLine();
            isValidInteger(theValue);
            System.out.println("Please enter original base: ");
            initialBase = s.nextInt();
            System.out.println("Please enter new base: ");
            finalBase = s.nextInt();
            isValidBase(finalBase);
       }
        // check it
       // isValidInteger(theValue, finalBase);
        s.close();
        newNum = convertInteger(theValue, initialBase, finalBase);


        System.out.println("new number: " + newNum);
    }

    public static void isValidBase(int finalBase) {
        if (finalBase < 2 || finalBase > 36) {
            System.out.println("Error: Base must be greater than or equal to 2 & less than or equal to 36");
            System.exit(1);
        }
    }

    public static void isValidInteger(String num) {
        char chDigit;
        num = num.toUpperCase();
        for(int d = 0; d < num.length(); d++) {
            chDigit = num.charAt(d);
            if (!Character.isLetter(chDigit) && !Character.isDigit(chDigit)) {
                //System.out.println(chDigit);
                System.out.println("Error character is not a letter or number");
                System.exit(1);
            }
        }
    }


    public static String convertInteger(String theValue, int initialBase, int finalBase) {
        BigInteger bigInteger = new BigInteger(theValue,initialBase);
        String value = bigInteger.toString(finalBase);
        value = value.toUpperCase();
        return value;
    }
}