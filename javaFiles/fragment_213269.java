public static void getBooksWithPredicate(Predicate<Book> predicate, String errorMessage) {
    String bookDetails = "";
    Iterator<Book> iterator = allBooks.iterator();
    while(iterator.hasNext()) {
        Book b = iterator.next();
        if(predicate.test(b)){
            bookDetails = b.toString();
        }
    }

    if(bookDetails.isEmpty()){
        System.out.println(errorMessage);
    }
    System.out.println(bookDetails);
}