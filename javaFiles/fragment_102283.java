String input = et.getText().toString();
   SQLiteDatabase db = mHelper.getWritableDatabase();
   ContentValues values = new ContentValues();
   values.put(InputContract.TaskEntry.COL_TASK_TITLE,   input);     
   db.insertWithOnConflict(InputContract.TaskEntry.TABLE, null, values, SQLiteDatabase.CONFICT_REPLACE);                                        
   db.close();
   updateUI();