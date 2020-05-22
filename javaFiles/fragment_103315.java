@Override
    public int getItemCount() {
        return PinnedSongs.size() > 0 ? PinnedSongs.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (PinnedSongs.size() == 0) {
            return EMPTY_VIEW;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if (viewType == EMPTY_VIEW) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nothing, parent, false);
            EmptyViewHolder emptyViewHolder = new EmptyViewHolder(v);
            return emptyViewHolder;
        }
        //normal case
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.homeviewholder, parent, false);
        ViewHolder viewholder = new ViewHolder(v);
        return viewholder;
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    private static final int EMPTY_VIEW = 1000;