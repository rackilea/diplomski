public class MainActivity extends Activity 
{
    // Declare it here
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Reference it here
        edt = (EditText) findViewById(R.id.edt);

    }

    private void someName() {
        // You can use it here
        edt.setText("Hello");
    }

    private void otherName() {
        // You can also use it here and eveywhere in the whole class
        edt.setText("Hello");
    }
}