@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
        startActivity(new Intent(this, YourActivity.class));
        return true;
    }
    return super.onOptionsItemSelected(item);
}