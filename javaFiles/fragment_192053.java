//This should be a member variable
Double test;    

public void calculateTS(View v){
    String status;


    EditText editText = (EditText)findViewById(R.id.edtResult);
    Double num1 = 0.0;
    final String myStr = editText.getText().toString();
    if (myStr.isEmpty())
    {
        //num1 = Double.parseDouble(myStr); //looks like this is not used?

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.noinput),
                Toast.LENGTH_LONG).show();
    }
    else
    {
        test = Double.parseDouble(myStr);
        String result = String.format("%.2f", test);
        Log.d("MyActivity", result);

        if( test < 20.5) {
            status = "Poor";
        } else if (test >= 20.5 && test < 50.5){
            status = "Average";
        } else if (test >= 50.5 && test < 100.0) {
            status ="Well Done"; }
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Result Feedback...");
        alertDialog.setMessage(status);
        alertDialog.setButton("Acknowledged", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if(test< 20.5)){
                    String email = "test@test.com";
                    String subject = "Feedback";
                    String message = "Hello,\n\nTest.";
                    final Intent emailIntent = new Intent( android.content.Intent.ACTION_SEND );
                    emailIntent.setType( "plain/text" );
                    emailIntent.putExtra( android.content.Intent.EXTRA_EMAIL, new String[] { email } );
                    emailIntent.putExtra( android.content.Intent.EXTRA_SUBJECT, subject );
                    emailIntent.putExtra( android.content.Intent.EXTRA_TEXT, message );

                    startActivityForResult( Intent.createChooser( emailIntent, "Send Mail..."), 1234);
                }
            }
        });

        alertDialog.show();
    }