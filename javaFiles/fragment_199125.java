public Cursor getMaxMinScoresAllAndroid() {

    SQLiteDatabase db = this.getWritableDatabase();

    String tmptbl = "summed_scores";
    String tmptblcol = "sum_score";

    String crttmptbl = "CREATE TEMP TABLE IF NOT EXISTS " + tmptbl + "(" +
            tmptblcol + " INTEGER" +
            ")";
    String empttmptbl = "DELETE FROM " + tmptbl;

    db.execSQL(crttmptbl);
    db.execSQL(empttmptbl);
    String[] columns = new String[]{"sum(score) AS " + tmptblcol};
    Cursor csr = db.query(TB_SCORE,columns,null,null,COL_ID,null,null);
    DatabaseUtils.dumpCursor(csr);
    while (csr.moveToNext()) {
        ContentValues cv = new ContentValues();
        cv.put(tmptblcol,csr.getInt(csr.getColumnIndex(tmptblcol)));
        db.insert(tmptbl,null,cv);
    }
    csr.close();

    columns = new String[]{"max(" +
            tmptblcol +
            ") AS " + DERIVEDCOL_MAXSCORE,
            "min(" +
                    tmptblcol +
                    ") AS " + DERIVEDCOl_MINSCORE};
    return csr = db.query(tmptbl,columns,null,null,null,null,null);
}

public MaxMin getMaxAndminScoresAllAndroid() {
    MaxMin rv = new MaxMin(0,0);
    Cursor csr = getMaxMinScoresAllAndroid();
    if (csr.moveToFirst()) {
        rv.setMin(csr.getInt(csr.getColumnIndex(DERIVEDCOl_MINSCORE)));
        rv.setMax(csr.getInt(csr.getColumnIndex(DERIVEDCOL_MAXSCORE)));
    }
    csr.close();
    return rv;
}