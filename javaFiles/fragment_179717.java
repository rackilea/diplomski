import java.util.*;

public class App1 {
public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);


    int entry;
    int entry2;
    int entry3;
    boolean check = true;

    while(check) {
    System.out.println("Enter three integers");
    System.out.println("Side 1: ");
    entry = keyboard.nextInt();
    System.out.println("Side 2: ");
    entry2 = keyboard.nextInt();
    System.out.println("Side 3: ");
    entry3 = keyboard.nextInt();

    int a = entry*entry;
    int b = entry1*entry1;
    int c = entry2*entry2;

    if((a == b + c) || (b == a + c ) || (c == a + b) {
        System.out.println("The Triangle is right.");
        check = false;
    }

    else
    System.out.println("The Triangle is not right. Please try Again!!!");    
    }
    }

}