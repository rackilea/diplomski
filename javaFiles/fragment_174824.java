import java.util.Scanner;

public class Classtest2 {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("What number would you like to check for?");
        String number = myScanner.nextLine();
        if(isFound(number)){
            System.out.println("The number "+number+ " is there");
        }else{
            System.out.println("The number "+number+ " doesn't exist");
        }
    }

    public static boolean isFound(String number) {

        Scanner sc = new Scanner(Classtest2.class.getResourceAsStream("trombones.txt"));
        String word="";
        while (sc.hasNextLine()) {
            word = sc.next();

            if (word.equals(number.trim())) { 
                return true;
            }
        }
        return false;
    }
}