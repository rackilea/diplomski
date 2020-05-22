protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    submitButton = (Button) findViewById(R.id.submitAnswer);
    TextView ResetButton = (TextView) findViewById(R.id.ResetButton);

    submitButton.setOnClickListener(new View.OnClickListener() {
    ResetButton.setOnClickListener(new View.OnClickListener() {