//Change the name id in the xml file
   Button microsoftButton = (Button) findViewById(R.id.microsoftButton);
   TextView scoreTextView = (TextView) findViewById(R.id.scoreTextView);

       microsoftButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"Wrong!", Toast.LENGTH_SHORT).show();

               // This was declared above so now you can use it. You can only set it to a String not to an Integer.
               scoreTextView.setText("0");

          }
       });