import java.util.Scanner;
import java.util.ArrayList;

public class BookList {

    public static void main (String[] args){
        Scanner SC = new Scanner(System.in);
        Book a = new Book();

        a.setTitle("Stranger");

        Book b = new Book();
        b.setTitle("SQL");

        Book c = new Book();

        c.setTitle("HTML");

        ArrayList<Book> BookList = new ArrayList<Book>();
        BookList.add(a);
        BookList.add(b);
        BookList.add(c);

        int Choice1=1;

        while(Choice1!=5)
        {
            System.out.println(" =======================================");
            System.out.println("|       1. Add a book                   |");
            System.out.println("|       2. Edit a book                  |");
            System.out.println("|       3. Delete a book                |");
            System.out.println("|       4. Display all books            |");
            System.out.println("|       5. Exit the program             |");
            System.out.println("|  *Type a number to make a selection*  |");
            System.out.println(" =======================================");
            System.out.println("");
            System.out.print("Selection: ");

            Choice1 = SC.nextInt();

            switch (Choice1) {

                case 1:

                System.out.println("'Add a book' ");
                System.out.println("Enter the name ");
                Book holder = new Book(SC.next());

                break;
                case 2:
                System.out.println("'Edit a book's details' selected");
                System.out.println("Which Book would you like to edit?");
                System.out.println("");

                // I do not understand what you want me to do here

                break;

                case 3:
                for(int i=0;i<BookList.size();i++){
                    System.out.println(i+1+") "+BookList.get(i));
                }
                System.out.println("Choose a book to delete: ");
                BookList.remove(SC.nextInt()-1);
                break;

                case 4:
                System.out.println("Display all books");
                for(Book x:BookList)
                    System.out.println(x);
                break;


                case 5:
                System.out.println("Goodbye!");
                System.exit(0);

                break;

                default:
                System.out.println("Invalid selection. Try again");

            }
        }
    }
}











public class Book{

    String Title;


    public Book()
    {
        Title="";
    }

    public Book(String bookTitle)
    {
        Title=bookTitle;
    }

    public void setTitle(String bookTitle)
    {
        Title=bookTitle;
    }

    public String toString(){
        return "Book Name "+Title;
    }
}