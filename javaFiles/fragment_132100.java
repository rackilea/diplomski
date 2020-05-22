OldPoints = "my debugging value";
      Log.d("MYDEBUGGING","OldPoints, before doing anything is " + OldPoints);
      Cursor c_oldPoints= sqdb.query(DBHelper.TABLE_NAME2,null,DBHelper.NICKNAME+"=?",new String[]{Username},null,null,null);
      int col_Points=c_oldPoints.getColumnIndex(DBHelper.POINTS);
      c_oldPoints.moveToFirst();

      while (!c_oldPoints.isAfterLast())
         {

          OldPoints=c_oldPoints.getString(col_Points);
                        c_oldPoints.moveToNext();
          Log.d("MYDEBUGGING","Extracted the value " + OldPoints + " from position + String.valueOf(c_oldPoints.getPosition());
         }
     sqdb.close();

     Log.d("MYDEBUGGING","Trying to convert the value " + OldPoints + " to an integer");
     int OldP = Integer.parseInt(OldPoints);