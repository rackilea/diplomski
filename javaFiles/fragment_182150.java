public interface ListPage<T> {
    public List<T> getList();
    public int getTotal();
    public int getPage();
    public int getPages();
    public int getPerPage();
}