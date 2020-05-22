@Override
public boolean onOptionsItemSelected(MenuItem item) {

    if (item.getItemId() == android.R.id.home) {

        finish();

        return true;
    }
    else {
        return MenuActionBar.optionsItemSelected(this, null, item)
                ? true : super.onOptionsItemSelected(item);
    }

}