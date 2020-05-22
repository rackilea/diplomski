class Class2 {
    static int Count;
    ...
    protected void onListClick(List 2/*invalid name*/, View view, int position, long id)
    {
        ...
        Count = cursor.GetInt(countIndex);
        ...
    }
}