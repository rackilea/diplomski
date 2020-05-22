public class MainPage extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        android.support.v7.widget.Toolbar toolbar 
             = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);  
        ...