public class saveData extends AsyncTask < List < String > , Void, Void > {
    private OnTaskCompleted listener;
    boolean myflag = false;

    @Override
    public void onPreExecute() {}

    @Override
    protected Void doInBackground(List < String > ...params) {}

    @Override
    public void onPostExecute(Void result) {
        super.onPostExecute(result);
        onTaskCompleted(myflag);
    }
}