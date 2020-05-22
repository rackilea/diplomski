public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {

    TextView v = (TextView) LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_container_element, parent, true);

    MyViewHolder vh = new MyViewHolder(v);
    return vh;
}