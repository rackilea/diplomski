public class DatabaseHelper extends SQLiteOpenHelper {
    //...

    public void addNewThingyAsync(final String name, final Callback<Long> cb) {
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... ignoredParams) {
                return addNewThingy(name);
            }

            @Override
            protected void onPostExecute(Long result) {
                cb.callback(result);
            }
        }.execute();
    }

    //...

    public void getThingyByIdAsync(final long id, final Callback<Thingy> cb) {
        new AsyncTask<Void, Void, Thingy>(){
            @Override
            protected Thingy doInBackground(Void... ignoredParams) {
                return getThingyById(id);
            }

            @Override
            protected void onPostExecute(Thingy result) {
                cb.callback(result);
            }
        }.execute();
    }
    //...
}