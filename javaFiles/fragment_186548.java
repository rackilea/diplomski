import java.util.Scanner;

public class NewClass {

public static void main(String args[]) {
    Scanner book = new Scanner(System.in);
    String[] library = new String[4];
    library[0] = "Brazil";
    library[1] = "Japan";
    library[2] = "China";
    library[3] = "India";
    String bookEntry = " ";
    int day;
    int x = 2;
    int penalty;
    System.out.println("Insert name of the book: ");
    bookEntry = book.next();
    boolean present = false;
    for (int i = 0; i < library.length; i++) {
        if (bookEntry.equals(library[i])) {
            present = true;
            break;
        }
    }
    if (present) {
        System.out.println("The book was returned");
    } else {
        System.out.println("The book is out of order");
        System.out.println("\n" + bookEntry.toUpperCase() + " " + "is out since: ");
        day = book.nextInt();
        if (day > x) {
            penalty = day * 20;
            System.out.println("Total fine: " + penalty);
        } else {
            System.out.println("Not yet due.");
        }
    }
}
}