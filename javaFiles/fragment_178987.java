package com.example.shreeganesha.splash;

    private Button changeActivity; //Try more explicit names on your variables instead of just btn2, 
    // also declare your variables on top for better organized code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_beatness);
        init();
    }


    public void init(){
        changeActivity = (Button)findViewById(R.id.changeActivity);
        changeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(this, YourNewActivityClass.class);
                startActivity(i);
            }
        });
    }