//Methods for menu
// display the menu when menu botton clicked

@Override
public boolean onCreateOptionsMenu(Menu menu) {
   super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.lightmeter, menu);
    menu.findItem(R.id.about).setIntent(new Intent(this, about.class));
    menu.findItem(R.id.edit).setIntent(new Intent(this, menu.class));
    return true;
}

//methods for menu
//StartActivity for selecion

@Override
public boolean onOptionsItemSelected(MenuItem item) {
super.onOptionsItemSelected(item);
startActivity(item.getIntent());
return true;
}