@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.first,menu);
    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if(item.getItemId()==R.id.m1){
        Intent i = new Intent(this,MainActivitySecond.class);
        startActivity(i);
        return true;
    }
    return super.onOptionsItemSelected(item);
}