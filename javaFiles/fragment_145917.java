public class MyActivity extends Activity {

    private static class MySpan implements LineBackgroundSpan {
        private final int color;

        public MySpan(int color) {
            this.color = color;
        }

        @Override
        public void drawBackground(Canvas c, Paint p, int left, int right, int top, int baseline,
                int bottom, CharSequence text, int start, int end, int lnum) {
            final int paintColor = p.getColor();
            p.setColor(color);
            c.drawRect(new Rect(left, top, right, bottom), p);
            p.setColor(paintColor);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TextView tv = new TextView(this);
        setContentView(tv);

        tv.setText("Lines:\n", BufferType.EDITABLE);
        appendLine(tv.getEditableText(), "123456 123 12345678\n", Color.BLACK);
        appendLine(tv.getEditableText(), "123456 123 12345678\n", Color.RED);
        appendLine(tv.getEditableText(), "123456 123 12345678\n", Color.BLACK);
    }

    private void appendLine(Editable text, String string, int color) {
        final int start = text.length();
        text.append(string);
        final int end = text.length();
        text.setSpan(new MySpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
}