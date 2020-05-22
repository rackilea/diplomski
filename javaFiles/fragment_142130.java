@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
            super.onBackPressed();
            return true;
    }
    return super.onOptionsItemSelected(item);
}