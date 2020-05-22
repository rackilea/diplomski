@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
getMenuInflater().inflate(R.menu.menu, menu); return true; } 


@Override 
public boolean onOptionsItemSelected(MenuItem item) {
 switch (item.getItemId()){ 
case R.id.logout:
 FirebaseAuth.getInstance().signOut();
 startActivity(new Intent(MainActivity.this, StartActivity.class)); finish(); return true; }