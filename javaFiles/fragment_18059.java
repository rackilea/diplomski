public class CustomActivity extends AppCompatActivity {

    private String mChangedData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomAsyncTask task = new CustomAsyncTask();
        task.setOnDataChangedListener(new CustomAsyncTask.OnDataChangedListener() {
            @Override
            public void onDataChanged(String data) {
                mChangedData = data;
            }
        });
        task.execute(1);
    }

    private static class CustomAsyncTask extends AsyncTask<Integer, Void, Void> {

        private OnDataChangedListener onDataChangedListener;
        @Override
        protected Void doInBackground(Integer... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(onDataChangedListener != null) {
                onDataChangedListener.onDataChanged("foo");
            }
        }

        void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
            this.onDataChangedListener = onDataChangedListener;
        }

        interface OnDataChangedListener {
            void onDataChanged(String data);
        }
    }
}