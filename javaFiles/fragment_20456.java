@Override
public boolean onOptionsItemSelected(MenuItem item) {
switch (item.getItemId()) {
...
case android.R.id.home:

Intent intent = new Intent(this, NewFragmentActivity.class);
intent.putExtra(...); // so you can pass what activity you're coming from, if needed
startActivity(intent);
this.finish();