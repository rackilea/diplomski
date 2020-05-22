private RelativeLayout mRelativeLayout;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_your);
    // findViewById for RelativeLayout
    mRelativeLayout = (RelativeLayout) findViewById(R.id.your_relative);
    // add LinearLayout
    LinearLayout linear = new LinearLayout(this);
    linear.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    // set setOrientation
    linear.setOrientation(LinearLayout.VERTICAL);
    for (int i = 0; i < 3; i++) {
        LinearLayout row = new LinearLayout(this);
        row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        row.setGravity(Gravity.CENTER_HORIZONTAL);
        row.setPadding(0, 40, 0, 0);

        for (int j = 0; j < 3; j++) {
            Button eBtn = new Button(this);
            eBtn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            eBtn.setText("" + (j + 1 + (i * 3)));
            eBtn.setId(j + 1 + (i * 3));

            eBtn.setBackgroundResource(R.drawable.exercisebutton);
            // add view to the inner LinearLayout
            row.addView(eBtn);

            eBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                    id = "" + view.getId();
                    intent.putExtra(EXTRA_MESSAGE, id);
                    startActivity(intent);
                }
            });
        }
        // add view to the outer LinearLayout
        linear.addView(row);
    }
    mRelativeLayout.addView(linear);
}