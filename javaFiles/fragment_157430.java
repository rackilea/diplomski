public class MainActivity extends AppCompatActivity {
    private LinearLayout root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.your_layout_name);
        root = findViewById(R.id.whatever_id_you_gave_your_linearlayout_in_xml);
    }
}