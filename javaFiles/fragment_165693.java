@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button mButton = (Button) findViewById(R.id.More);
       final TextView mTextView = (TextView)findViewById(R.id.Antal);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                  mTextView.setText("Some Text");
            }
        });
}