@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean defaultValue = false; //or true as you need
        if(getIntent().getBooleanExtra("shouldChangeButton", defaultValue)) {
            ImageButton ib = (ImageButton) findViewById(R.id.imagebutton);
            ib.setImageResource(R.drawable.img);
        }
    }