public Cursor showResults(String selectedAvgStds){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor results = db.rawQuery("select * from "+TEMP_TABLE+"where value = " + selectedAvgStds , null);
        return results;
     }
}