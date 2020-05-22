private class LongOperation extends AsyncTask<Void, Void, Void> {

    long lastID;
    int count;
    ContentResolver cr;

    public LongOperation(final long lastID, final int count,
                                    final ContentResolver cr){
        this.lastID = lastID;
        this.count = count;
        this.cr = cr;
    }