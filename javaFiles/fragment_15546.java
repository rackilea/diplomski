public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    switch (viewType) {
        case TYPE_SMS_MESSAGE:
            // return a view as you did before
        case TYPE_PHONE_CALL:
            // return a view as you did before
        case TYPE_SECTION_HEADER:
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.section_header_layout, null);
            return new YourRecyclerViewHolder(v);
        default:
            return null;
    }
}