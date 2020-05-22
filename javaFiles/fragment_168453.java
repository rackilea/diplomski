public class PaginationActivity extends Activity {
    private TextView mTextView;
    private Pagination mPagination;
    private CharSequence mText;
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagination);

        mTextView = (TextView) findViewById(R.id.tv);

        Spanned htmlString = Html.fromHtml(getString(R.string.html_string));

        Spannable spanString = new SpannableString(getString(R.string.long_string));
        spanString.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanString.setSpan(new RelativeSizeSpan(2f), 0, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanString.setSpan(new StyleSpan(Typeface.MONOSPACE.getStyle()), 0, 24, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanString.setSpan(new ForegroundColorSpan(Color.BLUE), 700, spanString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanString.setSpan(new RelativeSizeSpan(2f), 700, spanString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanString.setSpan(new StyleSpan(Typeface.MONOSPACE.getStyle()), 700, spanString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mText = TextUtils.concat(htmlString, spanString);

        mTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // Removing layout listener to avoid multiple calls
                mTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mPagination = new Pagination(mText,
                        mTextView.getWidth(),
                        mTextView.getHeight(),
                        mTextView.getPaint(),
                        mTextView.getLineSpacingMultiplier(),
                        mTextView.getLineSpacingExtra(),
                        mTextView.getIncludeFontPadding());
                update();
            }
        });

        findViewById(R.id.btn_back).setOnClickListener(v -> {
            mCurrentIndex = (mCurrentIndex > 0) ? mCurrentIndex - 1 : 0;
            update();
        });
        findViewById(R.id.btn_forward).setOnClickListener(v -> {
            mCurrentIndex = (mCurrentIndex < mPagination.size() - 1) ? mCurrentIndex + 1 : mPagination.size() - 1;
            update();
        });
    }

    private void update() {
        final CharSequence text = mPagination.get(mCurrentIndex);
        if(text != null) mTextView.setText(text);
    }
}