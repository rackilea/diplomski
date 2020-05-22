//Einstellungen.java

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
        case android.R.id.home:
            super.onBackPressed();
            return true;

        default:
            return super.onOptionsItemSelected(item);
    }
}