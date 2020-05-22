private class MyAdapter extends RecyclerView.Adapter {

    private final Object[] items;

    public MyAdapter(Object[] items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    @Override
    public int getItemViewType(int position) {
        Object item = items[position];

        if (item instanceof VerticalItem) {
            return R.layout.newsfeed_vertical;
        } else if (item instanceof HorizontalItem) {
            return R.layout.newsfeed_horizontal;
        } else if (item instanceof AdItem) {
            return R.layout.newsfeed_ad;
        } else {
            throw new IllegalStateException("unexpected item type: " + item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(viewType, parent, false);

        switch (viewType) {
            case R.layout.newsfeed_vertical: return new VerticalViewHolder(itemView);
            case R.layout.newsfeed_horizontal: return new HorizontalViewHolder(itemView);
            case R.layout.newsfeed_ad: return new AdViewHolder(itemView);
            default: throw new IllegalStateException("unexpected viewType: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case R.layout.newsfeed_vertical: verticalView((VerticalViewHolder) holder, position);
            case R.layout.newsfeed_horizontal: horizontalView((HorizontalViewHolder) holder, position);
            case R.layout.newsfeed_ad: adView((AdViewHolder) holder, position);
            default: throw new IllegalStateException("unexpected viewType: " + viewType);
        }
    }

    // ...
}