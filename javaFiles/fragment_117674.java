private static final int[] idArray = {R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5};

private Button[] bt = new Button[idArray.length];

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.start_layout);

    for (int i=0; i<idArray.length; i++) {
        final int b = i;
        bt [b] = (Button)findViewById(idArray[b]); // Fetch the view id from array
        bt [b].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Start.this, MainActivity.class);
                myIntent.putExtra("players", b);
                startActivity(myIntent);

                //startActivity(new Intent(Start.this, MainActivity.class));
            }
        });

    }
}