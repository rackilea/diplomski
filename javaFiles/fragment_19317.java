ListAdapter adapter = new SimpleCursorAdapter(MyList, Layout, c,
new String[] { "Name", "Score" }, to)
{
public boolean areAllItemsEnabled()
{
return false;
}

public boolean isEnabled(int position)
{
return false;
}
};