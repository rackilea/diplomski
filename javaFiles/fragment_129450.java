//..
@Override
@Caching( cacheable = {
        @Cacheable(cacheNames = "sth"),
        @Cacheable(cacheNames="everythingelse")
})
public Book getByIsbn(String isbn) {
    simulateSlowService();
    return new Book(isbn, "Some book");
}
//..