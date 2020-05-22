final Dialog dialog = new Dialog(MainActivity.this);
      // Include dialog.xml file
      dialog.setContentView(R.layout.forgotpassword);
      // Set dialog title
      dialog.setTitle("ALERT!!");
      // set values for custom dialog components - text, image and button
      Button okbtn = (Button) dialog.findViewById(R.id.okbtn);
      Button cancelbtn = (Button) dialog.findViewById(R.id.cancelbtn);
      final EditText emailedittext = (EditText) dialog.findViewById(R.id.emailedittext);
      dialog.show();
      dialog.getWindow().setSoftInputMode(
              WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
      // if decline button is clicked, close the custom dialog
      cancelbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              // Close dialog
              dialog.dismiss();
          }
      });
      okbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String email=emailedittext.getText().toString();
              //do something more here
          }
      });