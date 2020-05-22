@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageView imageView = (ImageView) findViewById(R.id.indoor_activities);
    imageView.bringToFront();
    imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    Intent myIntent = new Intent (MainActivity.this,indoorActivities.class);
    startActivity(myIntent);
});// click listener for indoor activities
// click listener for outdoor activities when onCreated is called
    ImageView imageView = (ImageView) findViewById(R.id.outdoor_activities);
    imageView.bringToFront();
    imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    Intent myIntent = new Intent(MainActivity.this, outdoorActivities.class);
    startActivity(myIntent);
});