public abstract class BaseAdapter<T> extends ArrayAdapter<T>
{
    ....
    private List<T> items;
    ....
    protected abstract List<? extends T> build(JSONArray jsonArray);
    ....
    @Override
    public T getItem(int position)
    {
        return items.get(position);
    }
}