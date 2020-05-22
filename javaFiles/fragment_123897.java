@Override
public int getItemViewType(int position) {
    if (designList.size() == 0) return R.layout.empty;
    else return R.layout.normal_layout;
}

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
    ViewHolder viewHolder = null;
    if (viewType == R.layout.empty) {
        viewHolder = new EmptyViewHolder(view);
    } else {
        viewHolder = new NormalViewHolder(view);
    }
    return viewholder;
}

@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceOf EmptyViewHolder){
        // this is empty item, update view appropriately if needed
    } else {
        // this is normal item, update view appropriately if needed
    }
}