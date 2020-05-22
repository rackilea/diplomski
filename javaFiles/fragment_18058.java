public class CustomActivity extends AppCompatActivity {

    String mChangedData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Method 1 - change data into the anonymously implemented AsyncTask class
        new AsyncTask<Integer, Void, Void>() {

            @Override
            protected Void doInBackground(Integer... params) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                CustomActivity.this.mChangedData = "foo"; // this changes mChangedData as "foo"
            }
        }.execute(1);

        // Method 2 - change data into the custom AsyncTask class
        new CustomAsyncTask(this).execute(2);
    }

    public void setChangedData(String changedData){
        this.mChangedData = changedData;
    }

    static class CustomAsyncTask extends AsyncTask<Integer, Void, Void> {
        CustomActivity mActivity;
        public CustomAsyncTask(CustomActivity activity) {
            this.mActivity = activity;
        }
        @Override
        protected Void doInBackground(Integer... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mActivity.setChangedData("bar");
        }
    }
}