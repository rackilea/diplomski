Global.dbMain.openDataBase();
System.out.println("database open ");
    try
    {
      Cursor c = Global.dbMain.execQuery("select * from tableName", null);
      while(c.moveToNext())
       {
         System.out.println("in while");
         String str= c.getString(1);
       }
      c.close();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
Global.dbMain.close();