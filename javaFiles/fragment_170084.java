public void call_action(){
    String phnum = etPhoneno.getText().toString();
    Intent callIntent = new Intent(Intent.ACTION_CALL);
    callIntent.setData(Uri.parse("tel:" + phnum));
    startActivity(callIntent);
   }