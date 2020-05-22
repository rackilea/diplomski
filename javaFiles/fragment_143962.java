enum Direction { ASCENDING, DESCENDING }
public interface ISort {
    String getField();
    void setField(final String field);
    Direction getSort();
    void setSort(final Direction type);
}