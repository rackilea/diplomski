public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) findViewById(R.id.linearLayout);
        Snackbar.make(customLinearLayout, "Text to display", Snackbar.LENGTH_LONG).show();

    }

}