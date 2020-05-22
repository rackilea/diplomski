public static <T> T withPaging(Supplier<T> call, int pageSize, int pageNumber) {
    try {
        PaginationKit.setPaginationInput(pageSize, pageNumber); // Set threadlocal
        return call.get();
    } finally {
        PaginationKit.clearPaginationInput(); // Clear threadlocal
    }
}