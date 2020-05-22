public void onClick(View v) {
    number=ccnumber.getText().toString();
    if(number.length()!=16)
        Toast.makeText(getApplicationContext(),"please enter a number of 16 digits",Toast.LENGTH_LONG).show();
    else if(number.length()==16)
    {
        result=validate(number);

        // ** moved if ... else here. The value of result will atleast be set

        if(result.equals("Card is Valid")) // more correct comparison, but as recommended above, use a boolean instead, ie : if (result)
        {
            dm.finalupdate(mailid,productnamearray,checkarray,id_array);
            Toast.makeText(getApplicationContext(),"Transaction completed!",Toast.LENGTH_LONG).show();
            btnccconfirm.setVisibility(View.INVISIBLE);

            // ** Why are you calling onBackPressed here? onBackPressed is an activity
            // method called when the android 'back' button is pressed by the user. If
            // you wanna exit out of the activity, use Activity.finish() or use 
            // activity.setResult(), then call Activity.finish() (look up the developer docs)
            onBackPressed();
        }
        else if(result.equals("Card is Invalid"))
        {
            Toast.makeText(getApplicationContext(),"Invalid credit card number",Toast.LENGTH_LONG).show();
        }
    }
}