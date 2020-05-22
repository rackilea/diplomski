@Override
protected void onCreate( Bundle savedInstanceState ){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = (Button) findViewById(R.id.mybtnID);
    button2 = (Button) findViewById(R.id.button2);
    textView2 = (textView) findViewById(R.id.textView2);

    list.add("abc");
    abc = (String) list.get(0);


    button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick( View view ){
            textView.setText(abc);
        }
    });

    button2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick( View view ){
            size = list.size();
            textView2.setText(size);
        }
    });
}