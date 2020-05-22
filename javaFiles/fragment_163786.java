//region Sending
    try{
        ds = new DataSource(cont);
        ds.open();
        final Cursor cursor = ds.send();
        if(cursor.moveToFirst())
        do {

            //region Sending Variables
            final String CELL_NO = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_PHONE_NUM));
            final String M_DATE = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_DATE));
            final String M_TIME =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_TIME));
            final String EMP_ID = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_EMP_ID));
            final String UserID = String.valueOf(LoginActivity.ID) ;
            final String DOC_ID = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_DOC_ID));
            final String SA= cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_SA));
            final String NOTE = " - ";
            final String CO_ID = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_CO_ID));
            final String LAT =cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_LOC_LAT));
            final String LNG=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DA_LOC_LON));
            //endregion

            //region Sending Data
            Log.v("jarvis","Line = 1");
            StringRequest stringRequest = new StringRequest(Request.Method.POST,url,
                    new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            ds.updateStatus(DOC_ID,M_DATE,M_TIME,EMP_ID); //true
                            Toast.makeText(cont,"Uploaded And Saved.." ,Toast.LENGTH_SHORT).show();
                            Log.v("jarvis","Line = 2");
                        }
                    }
                    , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.v("jarvis","Line = 3");
                    ds.updateFalse(DOC_ID,M_DATE,M_TIME,EMP_ID); //true
                    Toast.makeText(cont,"Error.." ,Toast.LENGTH_SHORT).show();
                    error.printStackTrace();
                }
            }){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Log.v("jarvis","Line = 4");

                    Map<String, String> param = new HashMap<String, String>();
                    param.put("CELL_NO", CELL_NO);
                    param.put("M_DATE", M_DATE);
                    param.put("M_TIME", M_TIME);
                    param.put("EMP_ID", EMP_ID);
                    param.put("DOC_ID", DOC_ID);
                    param.put("SA", SA);
                    param.put("NOTE", NOTE);
                    param.put("CO_ID", CO_ID );
                    param.put("LAT", LAT);
                    param.put("LNG",LNG);
                    param.put("USER_ID",UserID);
                    return param;
                }
            };
            Log.v("jarvis","Line = 5");
            MySingleton.getmInstance(cont).addToRequestQue(stringRequest);
            //endregion
            Log.v("jarvis","Line = 6");

        }while (cursor.moveToNext());
    }catch(Exception e){}
    //endregion