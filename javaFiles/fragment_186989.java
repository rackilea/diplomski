@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);        
    LinearLayout layout = (LinearLayout)findViewById(R.id.activity_main);

    int [] a = {1,2};        
    String [] s = {"textView1","textView2"};
    for(int i =0; i <a.length; i++)
    {
        TextView info = new TextView(this); //actually really confused as to what the context I'm setting is - why this? Just saw other people do it like so
        info.setText(s[i]);
        info.setId(a[i]);
        info.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),
                       "clicked:"+v.getId(),Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(MainActivity.this,
                        NewActivity.class);
                myIntent.putExtra("key", v.getId()); //this is always the same
                startActivity(myIntent);
            }
        });
        layout.addView(info);
    }