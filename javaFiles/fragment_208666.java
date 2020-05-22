import java.util.Comparator;

public class Book implements Comparable {

  String isbn;
  String title;

  public Book(String id, String title) {
    this.isbn = id;
    this.title = title;
  }

  String getIsbn() {
    return isbn;
  }

  String getTitle() {
    return title;
  }

  @Override
  public int compareTo(Object o) {
    return Comparator
            .comparing(Book::getIsbn)
            .thenComparing(Book::getTitle)
            .compare(this, (Book) o);
  }

  @Override
  public  String toString() {
    String output = new StringBuilder()
            .append(isbn).append(":").append(title)
            .toString();
    return output;
  }
}