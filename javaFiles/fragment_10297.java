int creditunit,gpunit;
cursor = db.rawQuery("select sum(credit_unit) from FROM COURSES C INNER JOIN SEMESTER S ON S.semester_id=C.semester_id AND S.LEVEL_ID = C.LEVEL_ID AND S.LEVEL_CODE = C.LEVEL_CODE WHERE C.semester_id =  ? ;", new String[]{String.valueOf(id)});
if(cursor.moveToFirst())
    creditunit =cursor.getInt(0);
else
    creditunit = -1;
cursor.close();

cursor = db.rawQuery("select sum(gp_unit) FROM COURSES C INNER JOIN SEMESTER S ON S.semester_id=C.semester_id AND S.LEVEL_ID = C.LEVEL_ID AND S.LEVEL_CODE = C.LEVEL_CODE WHERE C.semester_id =  ? ;", new String[]{String.valueOf(id)});
if(cursor.moveToFirst())
    gpunit =cursor.getInt(0);
else
    gpunit = -1;
cursor.close();
//perform division
double sol= creditunit/gpunit;