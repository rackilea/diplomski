public class manager extends AsyncTask<Void, Void, String> {

 public  Context context; <-- Declared but not initialized

    @Override
    protected String doInBackground(Void... params) {

        CreateDB dbhelp = new CreateDB(context);
}