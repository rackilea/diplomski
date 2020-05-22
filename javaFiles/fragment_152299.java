public class Results extends Activity {
    int cAnswers=0;
    int wAnswers=0;
    QuestionView qv = new QuestionView();
    ArrayList<Question> queryList = qv.getQueries();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultsmain);
        cAnswers = getIntent().getIntExtra("correctAnswers", -1);
         wAnswers = getIntent().getIntExtra("wrongAnswers", -1);
       //your code here...