@Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = View.inflate(context, R.layout.simple_list_item_1, parent, null);
        return new ViewHolder(view, viewType);
    }