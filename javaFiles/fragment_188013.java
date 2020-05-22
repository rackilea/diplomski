public class BookService {
    @GraphQLQuery(name = "books")
    //make sure the argument names and types match the Relay spec
    public Page<Book> getBooks(@GraphQLArgument(name = "first") int first, @GraphQLArgument(name = "after") String after) {
        //if you decide to fetch from a SQL DB, you need the limit and offset instead of a cursor
        //so, you can treat "first" as count as "after" as offset
        int offset = Integer.valueOf(after);
        List<Book> books = getBooksFromDB(first, offset);
        Page<Book> bookPage = PageFactory.createOffsetBasedPage(books, totalBookCount, offset);
        return bookPage;
    }
}