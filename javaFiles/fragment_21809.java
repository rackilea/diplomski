protected void doBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
    if (viewHolder instanceof RssViewHolder){
        RssViewHolder itemHolder = (RssViewHolder) viewHolder;
        ...
    } else {
        // Here, it can be RssLargeViewHolder or HighlightViewHolder
        RssLargeViewHolder itemHolder = (RssLargeViewHolder) viewHolder;
        ...
    }
}