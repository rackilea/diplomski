public boolean onOptionsItemSelected(MenuItem item){
if (item.getItemId()==R.id.action_add){

    Intent intent=new Intent(MainActivity.this,AddCity.class);
    startActivityForResult(intent, requestCode); //ex: requestCode = 1
    return (true);

}
return (super.onOptionsItemSelected(item));
}