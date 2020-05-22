public void onCreate(Bundle saved) {
    super.onCreate(saved);

    LinearLayout layout = new LinearLayout(this);
    layout.setPadding(20, 20, 20, 20);
    layout.setOrientation(LinearLayout.VERTICAL);

    TextView text = new TextView(this);
    text.setTextSize(18);
    text.setTextColor(Color.MAGENTA);
    text.setText(R.string.hello_world);

    layout.addView(text, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    setContentView(layout);
}