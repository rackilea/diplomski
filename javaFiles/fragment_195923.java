@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // 'home' is the id for the icon click in the action bar (i.e. up/back).
    if (item.getItemId() == android.R.id.home) {
        // do your thing and return true
        return true;
    }

    return super.onOptionsItemSelected(item);
}