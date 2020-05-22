public class QuizLoginScore extends AppCompatActivity {

        private List<ScoreItem> mScoreItems = new ArrayList<>();
        private ProgressDialog mProgressDialog;
        private String mScore;
        private TextView mScoreTextView;
        private Button mShareButton;
        private Button mExitButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.score_login_quiz);
            mScoreTextView = (TextView)findViewById(R.id.login_score_text);
            mShareButton = (Button)findViewById(R.id.login_share_button);
            mExitButton = (Button)findViewById(R.id.login_exit_button);
            new FetchScoresTask().execute();
            mScoreTextView.setText(mScore);
            mExitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Build.VERSION.SDK_INT >= 21){
                        finishAndRemoveTask();
                    }else{
                        finishAffinity();
                        System.exit(0);
                    }
                }
            });

            mShareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_TEXT,getScoreShareReport(mScore));
                    i.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.score_report_subject));
                    i = Intent.createChooser(i,getString(R.string.send_report));
                    startActivity(i);
                }
            });

        }

        public String getScoreShareReport(String score){
            String result;
            StringBuilder sb = new StringBuilder();
            sb.append("QuizApp!").
                    append("\n\n").
                    append("I Just Scored").
                    append(" \' ").
                    append(score).
                    append(" \' ").
                    append("marks out of \' 100 \' in Latest Quiz on QuizApp!\nWhats your Score Huh?");
            result = sb.toString();
            return result;
        }

        private class FetchScoresTask extends AsyncTask<Void, Void, List<ScoreItem>> {
            @Override
            protected void onPreExecute() {

                mProgressDialog = new ProgressDialog(QuizLoginScore.this);
                mProgressDialog.setTitle("Downloading Score");
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                mProgressDialog.setMessage("Please wait while the score is being downloaded!");
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
            }

            @Override
            protected List<ScoreItem> doInBackground(Void... params) {
                return new ScoreFetcher().fetchScoreItems();
            }

            @Override
            protected void onPostExecute(List<ScoreItem> scoreItems) {
                mScoreItems = scoreItems;
                for(int i = 0; i < mScoreItems.size(); i++){
                    if(mScoreItems.get(i).getUserId().equals(QuizLogin.mUserIdString)){
                        mScore = String.valueOf(mScoreItems.get(i).getScore());

            mScoreTextView.setText(mScore);
                        break;
                    }
                }
                mProgressDialog.dismiss();
            }

        }
    }