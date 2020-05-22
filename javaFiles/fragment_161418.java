@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_exit) {
        finish()
    }

    return super.onOptionsItemSelected(item);
}