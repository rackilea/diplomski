public class Books {
    private ArrayList<String> booksDB;  // this is a field of the Books class

    // when we create a new Books instance, we will initialize the booksDB field
    public Books() {
        booksDB = new ArrayList<String>();
        booksDB.ensureCapacity(20000);
    }
}