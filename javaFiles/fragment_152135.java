@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    // Respond to the action bar's Up/Home button
    case android.R.id.home:
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
}