@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean defaultValue = false; //or true as you need

        SharedPreferences prefs = getSharedPreferences("YourAppNamePrefs", MODE_PRIVATE);
        boolean shouldChangeButton = prefs.getBoolean("shouldChangeButton", defaultValue);

        if(shouldChangeButton) {
            ImageButton ib = (ImageButton) findViewById(R.id.imagebutton);
            ib.setImageResource(R.drawable.img);
        }
    }