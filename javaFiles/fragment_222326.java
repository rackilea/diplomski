interface Paging extends AutoCloseable {
    void close();
    static Paging withPaging(int pageSize, int pageNumber) {
        PaginationKit.setPaginationInput(pageSize, pageNumber);
        return ()->PaginationKit.clearPaginationInput();
    }
}