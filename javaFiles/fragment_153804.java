public static void main(String[] args) {
    Book book = new Book(25);

    int startPage = book.getCurrentPage();
    book.turnForward(5);
    int endPage = book.getCurrentPage();

    System.out.println("The book was turned " + endPage - startPage + " pages forward.");
}