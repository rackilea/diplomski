import java.util.*;

public class Task10 {

public static void main(String[] args) {
    System.out.println("Enter a year to check if it is a leap year");
    while(true){
    Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if(year == 0)
            break;
        if((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
            System.out.println(year + " is a leap year");
        else
            System.out.println(year + " is not a leap year");
    }
}

}