@Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view, viewType);
    }