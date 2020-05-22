public class DataItem
    {
    String data;
    LinkedList<String> history = new LinkedList<>();

    public DataItem (String data)
    {
        this.data = data;
    }

    public void setData (String data)
    {
        this.history.add(0, this.data);
        this.data = data;
    }
}