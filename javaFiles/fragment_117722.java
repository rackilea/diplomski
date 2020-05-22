public void setUp (String address) {
/* start an intent to pass the string data*/
Intent intent = new Intent(GridViewActivity.this,       MovieDetailActivity.class);

/* use the intent object to pass string to another activity using putExtra method */

intent.putExtra("your string");
 start intent(intent);
}