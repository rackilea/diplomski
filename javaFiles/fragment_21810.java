protected void doBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position) {
    if (viewHolder instanceof RssViewHolder){
        RssViewHolder itemHolder = (RssViewHolder) viewHolder;
        ...
    } else if (viewHolder instanceof RssLargeViewHolder) { 
        RssLargeViewHolder itemHolder = (RssLargeViewHolder) viewHolder;
        ...
    } else if (viewHolder instanceof HighlightViewHolder) {
        HighlightViewHolder itemHolder = (HighlightViewHolder) viewHolder;
        ...
    } else {
        // Log.e ("LOG_TAG", "Error.. Wrong type received");
    }
}