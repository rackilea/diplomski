Button next; 
          int a = 1;
          ImageView image;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            image = (ImageView) findViewById(R.id.i1);
            next = (Button) findViewById(R.id.next);
            next.setOnClickListener(this);

            Button restart = (Button) findViewById(R.id.restart);
            restart.setOnClickListener(this);

            Button previous = (Button) findViewById(R.id.previous);
            previous.setOnClickListener(this);
        }