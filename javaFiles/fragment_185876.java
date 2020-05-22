public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUi();
    }

    private void setupUi() {
        List<String> elements = new ArrayList<>(Arrays.asList(
                "Red",
                "Blue",
                "Green",
                "Black"
        ));

        DeadlineAdapter adapter = new DeadlineAdapter(this, elements);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}