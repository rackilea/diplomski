postButton = (Button) findViewById(R.id.postButton);
 // ADDITION
 final String user = getIntent().getStringExtra("username");
 final String password = getIntent().getStringExtra("password");
 // END ADDITION
 postButton.setOnClickListener(new View.OnClickListener()
 {
     @Override
     public void onClick(View view)
     {
         // EDITED
         new sendPost().execute(user, password);
     }
 });