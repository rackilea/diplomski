adapter = new FirebaseRecyclerAdapter<UserRace, OnlineListViewHolder>(options) {
    @Override
    public OnlineListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new instance of the ViewHolder, in this case we are using a custom
          View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.yourCustomLayout, parent, false);

          return new OnlineListViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(OnlineListViewHolder holder, int position, UserRace model) {
        // Bind the views
        // ...
    }
};