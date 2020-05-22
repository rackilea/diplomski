private final List<ContentItem> items;
private final OnItemClickListener listener;

public ContentAdapter(List<ContentItem> items, OnItemClickListener listener) {
    this.items = items;
    this.listener = listener;
}



@Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(items.get(position), listener);
}


public void bind(final ContentItem item, final OnItemClickListener listener) {
    ...
    itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            listener.onItemClick(item);
        }
    });
}


// in your Activity 

recycler.setAdapter(new ContentAdapter(items, new ContentAdapter.OnItemClickListener() {
    @Override public void onItemClick(ContentItem item) {
        Intent i = new Intent();
        i.putExtra("key","value");
        startActivity(i)
    }
}));