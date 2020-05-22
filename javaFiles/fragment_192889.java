@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button imeageTextBtn = (Button) findViewById(R.id.imeageTextBtn);
    assert imeageTextBtn != null;
    imeageTextBtn.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), activity2.class);
                startActivityForResult(intent, 0);
            }
        }
    );

}