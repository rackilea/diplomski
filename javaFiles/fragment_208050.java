public interface BookService extends Service {

    ServiceCall<NotUsed, Book> getAllBook();

    /**
     * @return
     */
    @Override
    default Descriptor descriptor() {

        return named("book").withCalls(
            restCall(GET, "/api/get-all-book", this::getAllBook)
        ).withAutoAcl(true);
    }
}