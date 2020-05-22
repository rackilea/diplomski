@Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //NOTE 4 (scroll to bottom)
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_list_item, parent, true);
        return new MemberViewHolder(itemView);
    }