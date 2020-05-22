public abstract class PaginationWrapper<T> {
    private int currentPage = 1;
    private int pageSize = 100;

    public ArrayList<T> getNextPage() {
        currentPage++;
        int startRow = currentPage * pageSize;

        // here we delegate to the implementation
        return getNextPage(startRow, pageSize);
    } 

    protected abstract ArrayList<T> getNextPage(int startRow, int pageSize);
}