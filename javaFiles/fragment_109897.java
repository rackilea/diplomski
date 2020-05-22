// The three generics here are: 
// 1) What is passed into doInBackground (invoked via .execute())
// 2) onProgressUpdate params (I didn't include that)
// 3) What is passed into onPostExecute
public class DoMyBackendWork extends AsyncTask<String, Void, String> {
    @Override
    protected void onPreExecute() {
        // do beforeXX(); stuff here, this runs on the UI thread
    }

    @Override
    protected String doInBackground(String... filePaths) {
        // do the xx(); code here.  It will be sequential, such as:
        // data = expensiveSetup();
        // procData = processData(data);
        // expensivePostDataThatCanBeDoneInBackground(procData);
        // return strings...;  This goes to onPostExecute
    }

    @Override
    protected void onPostExecute(String result) {
        // do afterXX(); stuff here, this runs on the UI thread
        // this data comes from the return of doInBackground
    }
    private void expensiveSetup() {}
    private ProcessedData processData(Data data) {}
    private void expensivePostDataThatCanBeDoneInBackground(ProcessedData data) {}
}