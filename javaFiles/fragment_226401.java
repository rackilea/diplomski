public class MainActivity extends AppCompatActivity {
    ...
    private EditText mEdtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Now you have the layout, you can find the view
        mEdtText = findViewById(R.id.edittext);

        ...
    }
}