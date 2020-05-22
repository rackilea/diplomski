@Override
public void onClick(View arg0) {
    // TODO Auto-generated method stub
    s1=medit_currency.getText().toString();
    savePreference(s1,s1);
    Intent i=new Intent(MainActivity.this,Next.class);
    // add below line
    intent.putExtra("s1", s1);
    startActivity(i);
}