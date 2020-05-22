public static void main(String[] args) throws Exception {
    Library books = new Library();
    books.add(new Book("The Gunslinger"));
    books.add(new Book("The Drawing of the Three"));
    System.out.println("After add: ");
    System.out.println(books);

    books.remove("The Gunslinger");
    System.out.println("After remove: ");
    System.out.println(books);      
}