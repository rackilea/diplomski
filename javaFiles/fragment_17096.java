I would try using a while loop to encase the switch. So it keeps asking your input. 
import java.util.Scanner;

public class SwitchTry {

public static void main(String[] args) {

while(true){
    int mth;
    String mthString;
    Scanner scanner = new Scanner(System.in);

    mth =scanner.nextInt();

    switch (mth) {
        case 1: mthString = "January";
            break;
        case 2: mthString = "February";
            break;
        case 3: mthString = "March";
            break;
        case 4: mthString = "April";
            break;
        case 5: mthString = "May";
            break;
        case 6: mthString = "June";
            break;
        case 7: mthString = "July";
            break;
        case 8: mthString = "August";
            break;    
        case 9: mthString = "September";
            break;
        case 10: mthString = "October";
            break;
        case 11: mthString = "November";
            break;
        case 12: mthString = "December";
            break;    
        default: mthString = "Error";
            break;
    }

    System.out.println(mthString);
}
}
}