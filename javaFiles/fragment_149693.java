package test;
import java.util.*;
import javax.swing.JOptionPane;

public class BookInfoMethod {
public static int totalBooks = 0;
public static List<BookInfoNews> list = new ArrayList<BookInfoNews>();      //create ArrayLis;

//default constructor
public BookInfoMethod() {
}
//add book method
public void addBook() {

    //show Input dialogue box to take input
    String isbn = "test";
    String bookName = "test";
    String authorName = "test";

    //add books data to ArrayList
    BookInfoNews newBook = new BookInfoNews(isbn, bookName, authorName);
    list.add(newBook);
    totalBooks++; //increment Total books

    //show notification after successful added book
    JOptionPane.showMessageDialog(null, "Book Name:  " +bookName + "  added successful\n" + "Total Books: " +totalBooks);

}
//delete book method
public void deletBook() {
    String del = "test";

   for (int i = 0; i < this.list.size() ; i++){
       if(del.equals(this.list.get(i).getBookName())){
           this.list.remove(i);
       }
   }
    totalBooks--; //decrement total books
    JOptionPane.showMessageDialog(null,"Total Books: " +totalBooks);
}

public BookInfoNews searchMethod(String bookName){
if(bookName == null){
    return null;
}
for(BookInfoNews tmp : this.list){
    if(bookName.equals(tmp.getBookName()))
        return tmp;
}
return null;
}
}

class BookInfoNews{
    private String isbn;
    private String bookName;
    private String authorName;
//default constructor
public BookInfoNews(String isbn,String bookName,String authorName) {
    this.isbn = isbn;
    this.bookName = bookName;
    this.authorName = authorName;
}
public String getIsbn() {
    return isbn;
}
public void setIsbn(String isbn) {
    this.isbn = isbn;
}
public String getBookName() {
    return bookName;
}
public void setBookName(String bookName) {
    this.bookName = bookName;
}
public String getAuthorName() {
    return authorName;
}
public void setAuthorName(String authorName) {
    this.authorName = authorName;
}


}

class BookInfoNewMain {
public static void main(String[] args) {
    BookInfoMethod obj = new BookInfoMethod();
    obj.addBook();
    obj.deletBook();
}
}