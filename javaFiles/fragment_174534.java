((Button) findViewById(R.id.skypemsg)).setOnClickListener(new OnClickListener()
  {
   @Override
   public void onClick(View v)
   {
     String skypeName = "yourSkypeName"; // <-- change this
     String mySkypeUri = "skype:"+skypeName+"?chat";
     SkypeUri(MainActivity.this, mySkypeUri);
   }
  });