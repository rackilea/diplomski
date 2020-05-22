class MyTask extends AsyncTask<...,..., FuncionResult> {
    Context mCtx;

    MyTask(Context ctx) {
        mCtx = ctx;
    }
    ...
   protected void onPostExecute(FunctionResult result) {
       ...
       Toast.makeText(mCtx, "text", 1000).show();
       AlertDialog.Builder builder = new AlertDialog.Builder(
    mCtx);
       builder.show();
   }
}