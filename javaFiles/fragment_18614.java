public long update_todo_not(String a, String b, String c, String d,
        String e, String f, String g, String id) {
     ContentValues con = new ContentValues();

     con.put("title", a);
     con.put("description", b);
     con.put("due_date", c);
     con.put("alarm_time", d);
     con.put("category", e);
     con.put("alarm_set",f);
     con.put("priority", g);
     Log.v("priority", g+"");
     return mDb.update(DATABASE_TABLE_TODO_LIST, con, "id ='" + id + "'",null);

}