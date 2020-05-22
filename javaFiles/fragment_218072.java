@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tcp);
        createDeck();
        d1=(ImageView)findViewById(R.id.d1);
        d1.setImageResource(R.drawable.clubs9);
    }