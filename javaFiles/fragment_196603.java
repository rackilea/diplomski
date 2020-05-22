private Book [] booklist;

public boolean borrowBook(Book b) {
    if (booklist == null) {
        booklist = new Book[3];
        booklist[0] = b;
        return true;
    }
    for (int i = 0; i < booklist.length; i++) {
        if (booklist[i] == null) {
            booklist[i] = b;
            return true;
        }
    }
    return false;
}

public static void main(String[] args) {
    Book caller = new Book();
    System.out.println(caller.borrowBook(new Book()));
    System.out.println(caller.borrowBook(new Book()));
    System.out.println(caller.borrowBook(new Book()));
    System.out.println(caller.borrowBook(new Book()));
}