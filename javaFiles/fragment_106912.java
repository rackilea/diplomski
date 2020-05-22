public class MainActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

private View mImageView;
private ObservableScrollView mScrollView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mImageView = findViewById(R.id.image);
    mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
    mScrollView.setScrollViewCallbacks(this);

}

@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
}

@Override
public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
    ViewHelper.setTranslationY(mImageView, scrollY / 2);
}

@Override
public void onDownMotionEvent() {

}

@Override
public void onUpOrCancelMotionEvent(ScrollState scrollState) {

}