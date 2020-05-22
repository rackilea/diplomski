import java.util.*;
import javax.swing.JOptionPane;

public class BookInfoNew {
    private String isbn;
    private String bookName;
    private String authorName;
    public int totalBooks = 0;

    // global list variable here which you can use in your methods
    private List<String> list;

    //default constructor
    public BookInfoNew() {
        list = new ArrayList<String>(); //create ArrayList
    }

    //Parameterized constructor - constructor has no return type
    public BookInfoNew(String x, String y, String z) {
        isbn = x;
        bookName = y;
        authorName = z;
    }

    //add book method
    public void addBook() {
        String isbn = JOptionPane.showInputDialog("Enter ISBN");

        //add books data to ArrayList
        list.add(isbn);
    }
}