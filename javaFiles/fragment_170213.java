public class Book {
    private boolean isAvailable;

    public Book(String cNum, int isbn, String title, String author, String classification, Shelves shelf){
       super(cNum, isbn, title, author, classification, shelf);
       this.isAvailable = true;
    }
}