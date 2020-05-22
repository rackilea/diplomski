public class MainScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        // If you're not using this view anywhere, you don't have to declare it globally. Use only a local variables
        TextView texting = (TextView) findViewById(R.id.MyText);
        texting.setText("Test");

    };
}