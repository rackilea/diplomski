public static List<Book> findMatch(Book id){
    List<Book> allBooks = JPA.em().createQuery("FROM Book").getResultList();
    List<Book> matchedBooks = new ArrayList<Book>(); 
    for(Book b : allBooks){
        if(isPossibleMatch(b, id)) //assuming you define a .isPossibleMatch() method
            matchedBooks.add(b);
    }
    return matchedBooks;
}