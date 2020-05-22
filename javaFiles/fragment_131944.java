public static void main(String[] args) {
    Comparator<Book> page = Comparator.comparing(Book::getPageNb);
    Comparator<Book> title = Comparator.comparing(Book::getTitle);

    ComplexComparator c1 = new ComplexComparator(page, title);
    ComplexComparator c2 = new ComplexComparator(page, true, title, false);
}