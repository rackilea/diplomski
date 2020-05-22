private String name;
private String Events_Table = "events";
private String[] Columns = {"_id", "Name", "Date", "Time_Slot", "Venue", "Details", "EHName", "EHNumber"} ;
private String WhereClause = Columns[1]+"=?" ;

    Cursor cursor = db.query(Events_Table, Columns, WhereClause, new String[] {name}, null, null, null);