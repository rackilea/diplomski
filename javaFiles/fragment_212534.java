@Override
    public void onBindViewHolder(RecycleViewHolder holder, final int position) {
        //............//
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });