...
cursor = db.getAllRecords();
if(cursor.getCount() > 0)
    DisplayRecords(cursor);
else
    DisplayNoRecordsMessage();