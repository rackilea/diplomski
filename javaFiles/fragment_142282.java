public class ScoreDisplay extends AppCompatActivity {

      TextView myScore;
       int score;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.scoredisplay);
            score= getIntent().getIntExtra("score",0);
            myScore = (TextView)findViewById(R.id.endingScore);

            myScore.setText(score+"");
           }
    }