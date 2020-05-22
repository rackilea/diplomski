@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
{
    super.onCreateOptionsMenu(menu, inflater);

    menu.clear();
    inflater.inflate(R.menu.toolbar_items_idle, menu);
}