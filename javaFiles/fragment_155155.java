ArrayList<Button> mButtonList = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    LinearLayout linear;
    linear = (LinearLayout) findViewById(R.id.ly);

    for (int i = 1; i < 4; i++) {
        final Button btn = new Button(this);

        btn.setId(1000 + i);
        btn.setBackgroundColor(Color.BLUE);
        btn.setMinimumHeight(150);
        btn.setMinimumWidth(150);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (Button button : mButtonList) {
                    if (button.getId() == view.getId()) {
                        button.setBackgroundColor(Color.RED);
                    } else {
                        button.setBackgroundColor(Color.BLUE);
                    }
                }
            }
        });

        linear.addView(btn);
        mButtonList.add(btn);
    }
}