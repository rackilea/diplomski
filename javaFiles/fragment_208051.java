public class BookServiceImpl implements BookService {

    @Override
    public ServiceCall<NotUsed, Book> getAllBook() {
        return request -> {
            Book myBook =     Book.builder().
                                name("BookName").
                                description("A description").
                                price("16€").
                                status("available").build();

            return completedFuture(myBook);
        };
    }
}