public class LoginTask extends AsyncTask<Void, Void, Void> {

    Context mContext;

    public LoginTask(Context ctx) {
        mContext = ctx;
    }


    @Override
    protected Void doInBackground(Void... voids) {
        // Login here
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Start Activity C
        Intent intent = new Intent(mContext, ActivityC.class);
        mContext.startActivity(intent);
    }
}