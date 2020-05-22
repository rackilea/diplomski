public class SortDTO implements ISort {
    private String field;
    private Direction sort;
    public SortDTO() { this(null, Direction.ASCENDING); }
    public SortDTO(String field, Direction sort) {
        this.field = field;
        this.sort = sort;
    }
    public String getField() { return field; }
    public void setField(String field) { this.field = field; }
    public Direction getSort() { return sort; }
    public void setSort(Direction sort) { this.sort = Objects.requireNonNull(sort); }
    @Override
    public String toString() {
        return String.format("Sort[field=%s, sort=%s]", this.field, this.sort);
    }
}