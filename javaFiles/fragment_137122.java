final String input = et.getText().toString();
 dialog.dismiss();

 // run in background
 AsyncTask.execute(new Runnable() {
   @Override
   public void run() {
     process(input);
   }
});