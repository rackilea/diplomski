mCursor = mDb.query("tracker", null, 
    " day_id BETWEEN ? AND ? AND year_id=? AND month_id=? ", new String[] { 
        String.valueOf(day1), String.valueOf(day2), String.valueOf(year1), 
        String.valueOf(month1)
    }, 
    null, null,  "_id ASC");