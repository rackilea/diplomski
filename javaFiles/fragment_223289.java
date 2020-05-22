@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(context,AppActivity.class);
                i.putExtra("number","784568435,438756435,435784365");
                i.putExtra("name","Travels1,Travels2,Travels3");
                startActivity(i);
            }
        });

        return;

    }