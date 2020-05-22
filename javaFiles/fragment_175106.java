public class Result extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = (TextView) findViewById(R.id.result);
        final Barcode barcode = getIntent().getParcelableExtra("barcode");
        result.setText(barcode.displayValue);
    }
}