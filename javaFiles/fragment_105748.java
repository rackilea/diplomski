public class NewsLoader extends AsyncTask<Void, Void, ArrayList<HashMap<String, String>>>{

public NewsLoader(CallBackReciever callBackReciever) {
        this.callBackReciever = callBackReciever;
    }
 @Override
    protected void onPreExecute() {
        startDialogue();

    }
    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(Void... params) {
        initAll(language);
        result = processNews()
        return result;
}
    @Override
    protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
        stopDialogue();
        callBackReciever.recieveData(result);
    }
}