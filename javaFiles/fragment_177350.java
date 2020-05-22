public class AutoChecker extends Activity {
    private CheckBox checkbox1;
    private CheckBox checkbox2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        checkbox1 = (CheckBox) findViewById(R.id.checkbox_1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox_2);

        new CheckerAsync(AutoChecker.this).execute(checkbox1, checkbox2);
    }

    private class CheckerAsync extends AsyncTask<CheckBox, CheckBox, Void>{
        private Activity mActivity;

        private CheckerAsync(Activity activity) {
            mActivity = activity;
        }
        @Override
        protected Void doInBackground(final CheckBox... checkboxes) {
            try {
                for(int i = 0, j = checkboxes.length; i < j; i++ ){
                    Thread.sleep(5000);
                    publishProgress(checkboxes[i]);
                }
            } catch (InterruptedException e) {}
            return null;
        }

        @Override
        public void onProgressUpdate(final CheckBox... checkboxes){
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    checkboxes[0].setChecked(true);
                }
            });
        }
    }
}