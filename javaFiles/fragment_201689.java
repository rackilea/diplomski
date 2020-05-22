public void SearchDialog(Context ctx){
           final Dialog dialog = new Dialog(ctx);
       dialog.setContentView(R.layout.dialogsearch);
       dialog.setTitle("       Enter The Text to Search");
       dialog.setCancelable(true);

       final EditText Text = (EditText) dialog.findViewById(R.id.EdText);

       Button buttonOK = (Button) dialog.findViewById(R.id.btnOK);
       buttonOK.setOnClickListener(new OnClickListener() {

           public void onClick(View v) {
                   String SearchText = Text.getText().toString();

               prefsPrivate =getSharedPreferences(Login.PREFS_PRIVATE,Context.MODE_PRIVATE);
                   Editor prefsPrivateEdit=prefsPrivate.edit();                        
                   prefsPrivateEdit.putString("Text",SearchText);
                   prefsPrivateEdit.commit();
                   Intent i = new Intent(ctx,SearchTask.class);
                   startActivity(i);
                   dialog.cancel();
           }
       });

       Button buttonCancel = (Button) dialog.findViewById(R.id.btnCancel);
       buttonCancel.setOnClickListener(new OnClickListener() {

           public void onClick(View v) {
                dialog.cancel();

           }
       });
       dialog.show();
   }