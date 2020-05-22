deger = new Boolean(response.toString());

if(deger)
{
   startActivity(intent);
}
else
{
   Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
}