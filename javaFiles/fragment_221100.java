import java.util.Scanner;

public class Snippet {
static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
    System.out.println("Enter 0 for loading the Library."
            + "\nEnter 1 for save and quit"
            + "\nEnter 2 for list all the Books in the Library."
            + "\nEnter 3 for add Book to the Library.");

    int answer = scanner.nextInt();
    scanner.nextLine();
    if(answer == 3)
        addBook();
}

private static void addBook() {
    System.out.println("Enter title: ");
    String title = scanner.nextLine();
    System.out.println("Enter director: ");
    String[] parts = scanner.nextLine().split(" ");
    String directorName = parts[0];
    String directorSurname = parts[1];
    System.out.println("title : " + title);
    System.out.println("directorname : " + directorName);
    System.out.println("directorsurname : " + directorSurname);
}
}