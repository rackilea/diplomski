private class DownloadTask extends AsyncTask<String, Void, String> {
    //Variable for storing the req id
    private int id;

    //Constants corresponding to your tasks
    public static int ID_ASYNC1 = 0;
    static static int ID_ASYNC1 = 0;
    static static  int ID_ASYNC1 = 0;

    @Override
    protected String doInBackground(String... params) {
        id = params[1]);
        //your code
    }

    @Override
    protected void onPostExecute(String result) {
        if(id == ID_ASYNC1){
            //Do your task #1
        } else if(id == ID_ASYNC2){
            //Do your task #2
        }
    }
}