EntityManager em = DBConfig.createEntityManager();
List<Books> booksByCategory = new ArrayList<>(); // Or whatever list type you need.

public BooksDAO(EntityManager em) {
    this.em = em;
}
public void setBooksByCategory(String category) {
    Query q = this.em.createQuery("SELECT b FROM Books b WHERE b.category = :category ", Books.class).setParameter("category", category);
    booksByCategory = q.getResultList();
}

public List<Books> getBooksByCategory(){
    return booksByCategory;
}