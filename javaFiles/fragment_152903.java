public void dialogCreation(int arg0) {
       // custom dialog
  final Dialog dialog = new Dialog(context,R.style.cust_dialog);
  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);           
  dialog.setContentView(R.layout.custom_dialog); 
   // set the custom dialog components - text, image and button
  TextView text = (TextView) dialog.findViewById(R.id.dialog_text);
  text.setTypeface(FontFactory.getBFantezy(getBaseContext()));                
  text.setText(Html.fromHtml(getStrint(arg0));

  Button dialogButton = (Button) dialog.findViewById(R.id.dialog_Button);             
  dialogButton.setTypeface(FontFactory.getBFantezy(getBaseContext()));
  dialogButton.setOnClickListener(new OnClickListener() {
     public void onClick(View v) {
        dialog.dismiss();
       }
  });
        dialog.show();
     }