if(party.toString().trim().length < 0 && p2.toString().trim().length < 0){

Toast.makeText(MainActivity.this, "empty fields", Toast.LENGTH_SHORT).show();

return;

}else {

db.execSQL("select * from Students where Name='"+party+"'and Password='"+p2+"'");

Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();

startActivity(new Intent(MainActivity.this,Welcome.class));

}