@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mItems = new ArrayList<>(30);
    for (int i = 0; i < 30; i++) {
        mItems.add(String.format("Card number %2d", i));
    }

    mAdapter = new CardViewAdapter(mItems);

    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(mAdapter);

    SwipeableRecyclerViewTouchListener swipeTouchListener =
            new SwipeableRecyclerViewTouchListener(mRecyclerView,
                    new SwipeableRecyclerViewTouchListener.SwipeListener() {
                        @Override
                        public boolean canSwipe(int position) {
                            return true;
                        }

                        @Override
                        public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                            for (int position : reverseSortedPositions) {
                                mItems.remove(position);
                                mAdapter.notifyItemRemoved(position);
                            }
                            mAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                            for (int position : reverseSortedPositions) {
                                mItems.remove(position);
                                mAdapter.notifyItemRemoved(position);
                            }
                            mAdapter.notifyDataSetChanged();
                        }
                    });

    mRecyclerView.addOnItemTouchListener(swipeTouchListener);
}