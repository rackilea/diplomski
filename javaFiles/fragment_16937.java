@Override
        public void onCreate(SQLiteDatabase db)
        {
            try{
            //db.execSQL("TABLE_CREATE");
             // Here you passing `TABLE_CREATE` string instead of passing `TABLE_CREATE` variable's string. So kindly remove quotes surrounded by 'TABLE_CREATE' and try.
              db.execSQL(TABLE_CREATE);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }