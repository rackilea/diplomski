public static <T,R> R withPaging(
    Function<T,R> call, T argument, int pageSize, int pageNumber) {

    try {
        PaginationKit.setPaginationInput(pageSize, pageNumber); // Set threadlocal
        return call.apply(argument);
    } finally {
        PaginationKit.clearPaginationInput(); // Clear threadlocal
    }
}