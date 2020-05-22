@Stateless
public class BookService {

    @PersistenceContext
    private EntityManager em;

    public List<Book> list() {
        return em.createQuery("FROM Book", Book.class).getResultList();
    }

    public Book find(Integer id) {
        return em.find(Book.class, id);
    }

    public Integer save(Book book) {
        em.persist(book);
        return book.getId();
    }

    public void update(Book book) {
        em.merge(book);
    }

    public void delete(Book book) {
        em.remove(em.contains(book) ? book : em.merge(book));
    }

}