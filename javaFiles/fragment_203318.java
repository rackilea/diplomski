public class ProcessTask extends AsyncTask<Void, Integer, String>{
    String s1, s2, s3, s4;

    public ProcessTask(String str1, String str2, String str3, String str4) {
        // TODO Auto-generated constructor stub
        s1 = str1;
        s2 = str2;
        s3 = str3;
        s4 = str4;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        //do something with strings
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        // TODO Auto-generated method stub

        //your code of parsing

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub

        super.onPostExecute(result);
    }
}