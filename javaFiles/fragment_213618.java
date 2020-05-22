String strMessage = yourEdittext.getText().toString());
        String strMessage1 = yourEdittext1.getText().toString());
        String strMessage2 = yourEdittext2.getText().toString());
    // so on you can directly set values
    // you have to just set values in string                      

      Intent i = new Intent(getApplicationContext(), nextactivity.class)   
      i.putExtra("new_variable_name",strMessage);
      i.putExtra("new_variable_name1",strMessage1);     
      i.putExtra("new_variable_name2",strMessage2);

      startActivity(i);