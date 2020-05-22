public class LoginTask extends AsyncTask<Object, Void, String> {

    public Context context;
    public ProgressDialog dialog;


    public BaseTask(Context context) {
        this.context = context;
        this.dialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        this.dialog.setMessage(context.getResources().getString(R.string.loading));
        this.dialog.show();

    }

    @Override
    protected String doInBackground(Object... objects) {
        String name = (String) objects[0];
        String password = (String) objects[1];
        String response = getInfo.getTours(name , password );
        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();

        // process response as you need
    }
}