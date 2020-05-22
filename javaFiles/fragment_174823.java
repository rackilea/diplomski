import java.util.Scanner;

    public class Classtest2 {
        public static void main(String[] args) {

        //    //1. class
        Scanner sc = new Scanner(Classtest2.class.getResourceAsStream("trombones.txt"));
        Scanner myScanner = new Scanner(System.in);

        System.out.println("What number would you like to check for?");
        String number = myScanner.nextLine() ;
        int lineNum = 0;

        while(sc.hasNextLine()) {
            word = sc.next();

            if(word.equals(number.trim())) { //here was the problem
                System.out.println("The number "+number+ " is there");

                return;
            } else {

            }
        } 
        System.out.println("not found");  // not found
    }