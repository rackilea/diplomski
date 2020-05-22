public class InsertCbtAsyncTask extends AsyncTask<CbtTable, Void, Void> {
    private CbtDao mCbtDao;
    private long id;
    private DoWithId callback;

    public InsertCbtAsyncTask(CbtDao cbtDao, DoWithId callback){
        mCbtDao = cbtDao;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(CbtTable... cbtTables) {
        id = mCbtDao.insertAutoThought(cbtTables[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        callback.doWithId(id);
    }

    interface DoWithId {
        public void doWithId(long id);
    }

}