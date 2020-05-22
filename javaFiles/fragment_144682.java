@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
        super.onBackPressed();
        overridePendingTransition(R.anim.enterAnim, R.anim.exitAnim);
        return true;
...