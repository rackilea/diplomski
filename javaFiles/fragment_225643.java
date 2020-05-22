import java.util.Scanner;
import java.lang.Math;

public class jpy_usd {
public static void main(String[] args) {
    //Initializing variables and the scanner
    String isSourceUSD;
    double usd;
    double usdMult = 0.00803568;
    int jpy;
    double jpyMult = 124.449;
    Scanner scanner = new Scanner(System.in);

    //Selecting an input currency and checking for valid input arguments
    System.out.println("Choose your input currency. Type \'USD\' for U.S. Dollars or \'JPY\' for Japanese Yen.");

        if(scanner.nextLine() .equalsIgnoreCase( "USD")) {
            isSourceUSD = "USD";
        } else if(scanner.nextLine() .equalsIgnoreCase( "JPY")) {
            isSourceUSD ="JPY" ;
        } else {
            isSourceUSD="NA";
            System.out.println("Invalid argument. Please use \'USD\' for U.S. Dollars or \'JPY\' for Japanese Yen.");
        }

    //Asking for the input in the chosen currency and converting
    if(isSourceUSD.equalsIgnoreCase("USD")) {
        System.out.println("Please enter the value to convert");
        usd = scanner.nextDouble();
        System.out.println(usd +" in JPY is "+ (Math.round(usd * jpyMult)));
    } else if(isSourceUSD.equalsIgnoreCase("JPY")) {
        System.out.println("Please enter the value to convert");
        jpy = scanner.nextInt();
        System.out.println(jpy+ " in USD is " +(Math.round(jpy * usdMult)));
        }
    else{
        System.out.println("Do nothing!!!");
    }
    scanner.close();
    }
}