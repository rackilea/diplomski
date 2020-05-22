private static final int VIEW_TYPE_MARKET_FEED = 0;
private static final int VIEW_TYPE_AD = 1;

...

@Override
public int getItemViewType(int position) {
    int viewType = VIEW_TYPE_MARKET_FEED;
    if (position % 6 == 5) {
        viewType = VIEW_TYPE_AD;
    }
    return viewType;
}