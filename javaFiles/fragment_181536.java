private int count = 0;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    //Connects the button by ID and reference to the design button
    Button andrewsButton = (Button) findViewById(R.id.andrewsButton);

    //When the button is clicked it will display the amount of times the button is clicked
    andrewsButton.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v) {
                    TextView andrewsText = (TextView) findViewById(R.id.andrewsText);
                    count++;
                    andrewsText.setText(String.valueOf(count));
                }
            }
    );