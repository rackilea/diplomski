public static List<Book> findMatch(Book id){
    Query query = JPA.em().createQuery("SELECT b FROM Book b WHERE b.fieldOne = :fieldOne AND b.fieldTwo : fieldTwo");
    query.setParameter("fieldOne", id.fieldOne);
    query.setParameter("fieldTwo", id.fieldTwo);
    return query.getResultList();
}