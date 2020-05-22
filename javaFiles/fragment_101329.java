import java.util.Scanner;

public class test {
    public test() {
        Scanner sc = new Scanner(System.in);
        String output = "Please enter a valid date";
        int month;
        int day;
        int k = 0;
// you can use do while loop. write some flag logic like I created k variable and it will be checked in while block
        do {
            System.out.println("What is your month of birth?");
            month = sc.nextInt();
            System.out.println("What is your day of birth?");
            day = sc.nextInt();

            if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19)) {
                System.out.println("You are an Aries");
            } else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20)) {
                System.out.println("You are a Taurus");
            } else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
                System.out.println("You are a Gemini");
            } else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22)) {
                System.out.println("You are a Cancer");
            } else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22)) {
                System.out.println("You are a Leo");
            } else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22)) {
                System.out.println("You are a Virgo");
            } else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22)) {
                System.out.println("You are a Libra");
            } else if ((month == 10 && day >= 23 && day <= 30) || (month == 11 && day >= 1 && day <= 21)) {
                System.out.println("You are a Scorpio");
            } else if ((month == 11 && day >= 22 && day <= 31) || (month == 12 && day >= 1 && day <= 21)) {
                System.out.println("You are a Sagittarius");
            } else if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19)) {
                System.out.println("You are a Capricorn");
            } else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 18)) {
                System.out.println("You are an Aquarius");
            } else if ((month == 2 && day >= 19 && day <= 29) || (month == 3 && day >= 1 && day <= 20)) {
                System.out.println("You are a Pisces");
            } else {
                System.out.println(output);
                k = 1;
            }
        } while (k == 1);

    }
}