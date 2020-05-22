public List<Registration> getList(SearchReport sc) 
    List<Registration> crReg = new ArrayList<Registration>();
    String selectQuery = "SELECT  * FROM " + TABLE_REGISTRATION + " WHERE " + DATE_COLUMN + " BETWEEN "
        + sc.getFrom() + " AND " + sc.getUntil() + " AND " + sc.getName();

    SQLiteDatabase db = this.getReadableDatabase();