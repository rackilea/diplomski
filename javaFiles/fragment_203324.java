void callBackgroundQuery(String query){
    if (android.os.Build.VERSION.SDK_INT >= 28){
        backgroundQueryAPI28 BQ = new backgroundQueryAPI28(this);
        BQ.execute(query);
    } else {
        backgroundQuery BQ = new backgroundQuery(this);
        BQ.execute(query);
    }
}

private class backgroundQueryAPI28 extends AsyncTask<String, Void, PrecomputedText>{
    private ReadingActivity mReadingActivity;

    final PrecomputedText.Params params = mTextView.getTextMetricsParams();
    final Reference textViewRef = new WeakReference<>(mTextView);

    public backgroundQueryAPI28(ReadingActivity ra){
        mReadingActivity = ra;
    }

    @Override
    protected PrecomputedText doInBackground(String... query) {
        SQLiteDatabase db = mDbHelper.getInstance(getApplicationContext()).getReadableDatabase();
        Cursor c = db.rawQuery(query[0],null);
        StringBuilder builder = new StringBuilder();
        String chap, verse, text;
        int bookNum;
        c.moveToFirst();
        while (!c.isAfterLast()) {
            bookNum = c.getInt(0);
            chap = c.getString(1);
            verse = c.getString(2);
            text = c.getString(3);
            String completeVerse = getAbbreviation(bookNum) + " " + chap + ":" + verse + " " + text;
            builder.append(completeVerse).append("\n");
            c.moveToNext();
        }

        String allText = builder.toString();
        final PrecomputedText precomputedText = PrecomputedText.create(allText, params);
        return precomputedText;
    }

    @Override
    protected void onPostExecute(PrecomputedText result) {
        super.onPostExecute(result);
        mTextView.setText(result);
        mReadingActivity.setScroll();
    }
}

private class backgroundQuery extends AsyncTask<String, Void, String>{
    private ReadingActivity mReadingActivity;

    public backgroundQuery(ReadingActivity ra){
        mReadingActivity = ra;
    }

    @Override
    protected String doInBackground(String... query) {
        SQLiteDatabase db = mDbHelper.getInstance(getApplicationContext()).getReadableDatabase();
        Cursor c = db.rawQuery(query[0],null);
        StringBuilder builder = new StringBuilder();
        String chap, verse, text;
        int bookNum;
        c.moveToFirst();
        while (!c.isAfterLast()) {
            bookNum = c.getInt(0);
            chap = c.getString(1);
            verse = c.getString(2);
            text = c.getString(3);
            String completeVerse = getAbbreviation(bookNum) + " " + chap + ":" + verse + " " + text;
            builder.append(completeVerse).append("\n");
            c.moveToNext();
        }

        String allText = builder.toString();
        return allText;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        mTextView.setText(result);
        mReadingActivity.setScroll();
    }
}