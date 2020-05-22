private class TimeHolder
{
    public String completeTime;
    public String restTime;
}

public List<TimeHolder> loadCompleteExercises(String workout)
{
    List<TimeHolder> listExercises = new ArrayList<TimeHolder>();

    db = dbHelper.getReadableDatabase();
    Cursor c = db.rawQuery("SELECT complete_time, rest_time FROM tbl_exercises WHERE workout = '"+workout+"';", null);
    c.moveToFirst();
    while(!c.isAfterLast()) {
        try
        {
            TimeHolder holder = new TimeHolder();
            if(c.isNull(c.getColumnIndex("exercise"))) {
                holder.completeTime = "00:00:05";
                holder.restTime = "00:00:00";
            }else {
                holder.completeTime = c.getString(c.getColumnIndex("complete_time"));
                holder.restTime = c.getString(c.getColumnIndex("rest_time"));
            }
            listExercises.add(holder);
        }
        catch (NullPointerException e)
        {
            Log.d("GET EXERCISES ERROR: ", e.toString());
        }
        c.moveToNext();
    }

    return listExercises;
}