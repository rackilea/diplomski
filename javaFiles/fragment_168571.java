public abstract class ParallaxHeaderActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

    private ObservableScrollView scrollView;
    private LinearLayout headerView;
    private FrameLayout contentView;

    private int headerHeight = 0;
    private int minimumHeaderHeight = 0;

    protected void setContentView(int layout, Fragment header, Fragment content){

        super.setContentView(layout);

        ViewGroup rootView = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        headerHeight = (int)convertDpToPixel(260, this);
        minimumHeaderHeight = (int)convertDpToPixel(160, this);

        int contentViewId = View.generateViewId();

        contentView = new FrameLayout(this);
        contentView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        contentView.setPadding(0, headerHeight, 0, 0);
        contentView.setId(contentViewId);

        scrollView = new ObservableScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scrollView.setScrollViewCallbacks(this);
        scrollView.setFillViewport(true);
        scrollView.addView(contentView);
        scrollView.setScrollViewCallbacks(this);

        IOverScrollDecor decor = new VerticalOverScrollBounceEffectDecorator(new ScrollViewOverScrollDecorAdapter(scrollView));
        decor.setOverScrollUpdateListener(new IOverScrollUpdateListener() {
            @Override
            public void onOverScrollUpdate(IOverScrollDecor decor, int state, float offset) {
                if (offset > 0) {
                    // 'view' is currently being over-scrolled from the top.
                    update((int)-offset);
                }

            }
        });

        rootView.addView(scrollView);

        addFragment(contentViewId, content);

        int headerViewId = View.generateViewId();

        headerView = new LinearLayout(this);
        headerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, headerHeight));
        headerView.setId(headerViewId);

        rootView.addView(headerView);

        addFragment(headerViewId, header);

    }


    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        update(scrollY);
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    private void addFragment(int id, Fragment fragment){

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    private void update(final int scrollY) {
        headerView.getLayoutParams().height = Math.max(headerHeight - scrollY, minimumHeaderHeight);
        headerView.requestLayout();
    }

    public static float convertDpToPixel(float dp, Context context){
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

}