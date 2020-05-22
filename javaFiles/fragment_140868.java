public class BlahActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blah);

        ProgressDialog pg = new ProgressDialog(this);
        pg.setTitle("Title of progress dialog");
        pg.setMessage("Message of progress dialog");
        pg.show();
    }

}