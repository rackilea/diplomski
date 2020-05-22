public class MainActivity extends Activity implements
    RecognitionListener {

    ProgressBar pb;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.layoutWithProgressbar);
        //^^^^^^^^^^^^^^^^^^^
        // without this, there is no layout or view hierarchy
        // attached with the MainActivity
        // or probably setContentView(R.layout.main_activity);
        pb = (ProgressBar) findViewById(R.id.pbar);
        //pb.setVisibility(View.INVISIBLE);
        pb.setVisibility(View.GONE);

    }
}