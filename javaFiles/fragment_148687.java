mButton.setOnClickListener( new View.OnClickListener()
         {
            public void onClick(View view)
             {
                collectionID = mEdit.getText().toString();
                 Log.d("EditText", collectionID);
                 // save value here in SharedPreferences
                 SharedPreferences settings = 
                            ConfigPage.this.getSharedPreferences(PREFS_NAME, 0);
                 SharedPreferences.Editor editor = settings.edit();
                 editor.putString(collectionID, collectionID);
                 editor.commit();
               }
         });