public abstract class PostSearchAdapter<T extends ISearchResult> extends RecyclerView.Adapter<PostSearchAdapter.PostSearchViewHolder> {
    // note change from private to protected
    protected final Context mContext;
    protected final ArrayList<T> mSearchResults = new ArrayList<T>();

    // constructor no longer handles weird type variable
    public PostSearchAdapter(Context context) {
        this.mContext = context;
    }

    // oncreate viewholder is removed on purpose

    @Override
    public void onBindViewHolder(PostSearchAdapter.PostSearchViewHolder viewHolder, int position) {
        viewHolder.bind(mSearchResults.get(position));
    }

    public void addData(List<T> newData) {
        mSearchResults.addAll(newData);
        notifyDataSetChanged();
    }

    public void clearData(){
        mSearchResults.clear();
    }

    @Override
    public int getItemCount() {
        return mSearchResults.size();  // this is never null
    }

    // ViewHolder template
    protected abstract class PostSearchViewHolder extends RecyclerView.ViewHolder{
        protected PostSearchViewHolder(View itemView) {
            super(itemView);
            // this can have some or all views that are shared between search results
        }

        protected abstract void bind(T data);
    }
}