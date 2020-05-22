public void refresh(View view){          //refresh is onClick name given to the button
  onRestart();
}

@Override
protected void onRestart() {

// TODO Auto-generated method stub
super.onRestart();
Intent i = new Intent(lala.this, lala.class);  //your class
startActivity(i);
finish();

}