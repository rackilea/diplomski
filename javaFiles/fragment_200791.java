public class TrackAdapter extends PostSearchAdapter<Track> {
    public TrackAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public PostSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // if all types share layout You can create helper method in superclass to inflate it
        View searchResult = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.list_item_search_result, parent, false);

        return new TrackViewHolder(searchResult);
    }

    protected class TrackViewHolder extends PostSearchViewHolder{
        protected TrackViewHolder(View itemView) {
            super(itemView);
            // store views not included in superclass in fields
        }

        @Override
        protected void bind(Track data) {
            // bind views to Track data...
        }
    }
}