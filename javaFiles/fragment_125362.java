@Override
public boolean onCreateOptionsMenu(Menu menu)
{
    getMenuInflater().inflate(R.menu.main, menu);

    // Show option depending on condition.
    MenuItem item = menu.getItem(R.id.menu_item_edit_post);
    item.setVisible(isUserPost());

    return true;
}