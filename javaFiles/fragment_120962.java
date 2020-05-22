public static class Pagination {

    private final List<String> sort;
    private final Optional<String> from;

    public Pagination(@QueryParam("sort") List<String> sort, 
                      @QueryParam("from") Optional<String> from) {
        this.sort = sort;
        this.from = from;
    }

    public List<String> getSort() { return sort; }
    public Optional<String> getFrom() { return from; }
}