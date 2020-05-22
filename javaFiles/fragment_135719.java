public class ListWrapper<T> {

    List<T> list;

    public ListWrapper (List<T> list) { this.list = list; }

    public List<T> getList () { return list; }        

}