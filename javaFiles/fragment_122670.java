public class MainActivity extends AppCompatActivity {
    private List<String> mItems = new ArrayList<>();
    private RecyclerView mRecycler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = findViewById(R.id.recyclerView);

        // Sample for vertical LinearLayoutManager.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Sample for GridLayoutManager with 4 spans. Each item comsumes 2 spans.
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
//        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return 2;
//            }
//        });

        // Add single dummy item that will be measured but not be displayed.
        mItems.add("Dummy item");
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(mItems);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(mAdapter);

        // Take measurements in OnPreDraawListener(). This could also be accomplished with
        // mRecyclerView.post(new Runnable()...)
        mRecycler.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                mRecycler.getViewTreeObserver().removeOnPreDrawListener(this);

                // RecyclerView is laid out with single dummy entry. Get how many of this type
                // of item can fit into the visible portion of the RecyclerView.
                final int nItems = getInitialLoadCount(mRecycler);
                Log.d(TAG, "<<<<Items per page=" + nItems);

                // Don't need the dummy entry any more.
                mItems.clear();
                mRecycler.getAdapter().notifyDataSetChanged();
                mItems = new ArrayList<>();

                // Fake load...
                loadInitialItems(nItems);
                return false;
            }
        });
    }

    // Determine how many items will fill one screen of the RecyclerView. Call with the
    // RecyclerView loaded with at least one item for measurement.
    private int getInitialLoadCount(RecyclerView recyclerView) {
        int itemsToLoad = 0;
        RecyclerView.LayoutManager lm = recyclerView.getLayoutManager();
        View firstChild = recyclerView.getChildAt(0);

        if (lm instanceof LinearLayoutManager) {
            Rect bounds = new Rect();
            recyclerView.getDecoratedBoundsWithMargins(firstChild, bounds);
            if (lm.canScrollVertically()) {
                int recyclerHeightForItems = recyclerView.getHeight() - recyclerView.getPaddingTop()
                    - recyclerView.getPaddingBottom();
                itemsToLoad = (recyclerHeightForItems + bounds.height() - 1) / bounds.height();
            } else if (lm.canScrollHorizontally()) {
                int recyclerWidthForItems = recyclerView.getWidth() - recyclerView.getPaddingLeft()
                    - recyclerView.getPaddingRight();
                itemsToLoad = (recyclerWidthForItems + bounds.width() - 1) / bounds.width();
            }
            if (lm instanceof GridLayoutManager) {
                // Adjust for GridLayoutManager. All items should to be the same number of spans.
                GridLayoutManager glm = (GridLayoutManager) lm;
                itemsToLoad *= glm.getSpanCount() / glm.getSpanSizeLookup().getSpanSize(0);
            }
        }
        return itemsToLoad;
    }

    private void loadInitialItems(final int itemCount) {
        // Simulate load of nItems...should be on non-UI thread.
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= itemCount; i++) {
                    sleep(250);
                    mItems.add("Item #" + i);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRecycler.swapAdapter(new RecyclerViewAdapter(mItems), true);
                    }
                });
            }
        }).start();
    }

    private static final String TAG = "MainActivity";
}