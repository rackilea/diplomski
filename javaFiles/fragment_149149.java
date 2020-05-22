new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... params) {

                myDbHelper2 = new DataBaseHelpername(YourActivity.this.getApplicationContext());
                myDbHelper2= new DataBaseHelpername(YourActivity.this);
                try {

                    myDbHelper2.createDataBase();

                }

                catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {

                    myDbHelper2.openDataBase();}

                catch (SQLException sqle) {

                    sqle.printStackTrace();

                }
                db = myDbHelper2.getReadableDatabase();
                mCursor= db.rawQuery("SELECT field_translation_fa_value,my_id  FROM name WHERE my_id ="+id+" ;",null);
                mCursor.moveToFirst();
                String ff=mCursor.getString(0);
                return ff;
            }


            @Override
            protected void onPostExecute(String ff) {
                super.onPostExecute(s);
                txtmatnfa.setText(ff);
            }
        }.execute();