@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_format_test);
    format();
    // Your custom code was here, deleted for readability
}

public void format() {
    TextView textView = (TextView)findViewById(R.id.test);

    CharSequence text = null;

    if (textView != null) {
        text = textView.getText();
    }

    String token = "^^";

    if (text != null) {
        int length = token.length();
        int start = text.toString().indexOf(token) + length;
        int end = text.toString().indexOf(token, start + length);

        if (start > -1 && end > -1) {
            SpannableStringBuilder ssb = new SpannableStringBuilder(text);
            ssb.setSpan(new ForegroundColorSpan(0xff000000), start, end, 0);
            ssb.delete(end, end + length);
            ssb.delete(start - length, start);

            textView.setText(ssb);
            System.out.println("format");
        }

        System.out.println("works");
    }

    System.out.println("running");
}