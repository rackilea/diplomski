AbstractPageRequest implements Pageable, Serializable {
    ...
    private final int page;
    private final int size;

    public long getOffset() {
        return (long)this.page * (long)this.size;
    }
    ...