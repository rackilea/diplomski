public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {

    View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_container_element, parent, true);

    return new MyViewHolder(v);
}