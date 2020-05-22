public class MainPeopleActivity2 extends ActionBarActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_MainPeopleActivity2);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                name= null;
            } else {
                name= extras.getString("Name");
            }
        } else {
            name = (String) savedInstanceState.getSerializable("Name");
        }

    }

  //...... rest of the code in this class