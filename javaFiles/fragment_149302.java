public static int dpToPx(int dp)
{
    return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
}
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
 // LinearLayout
    LinearLayout linearLayout = new LinearLayout(this);
    linearLayout.setOrientation(LinearLayout.VERTICAL);
    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

    // TextView1
    final TextView textView1 = new TextView(this);
    textView1.setText(R.string.app_name);

    textView1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
    textView1.setBackgroundColor(Color.RED);
    LinearLayout.LayoutParams lyp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dpToPx(100));
    linearLayout.addView(textView1, lyp1);

    // TextView2
    final TextView textView2 = new TextView (this);
    textView2.setText(R.string.app_name);
    textView2.setBackgroundColor(Color.BLUE);
    LinearLayout.LayoutParams lyp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
    linearLayout.addView(textView2, lyp2);

    setContentView(linearLayout);
}