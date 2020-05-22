@Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int i) {

        holder.URLName.setText( urlArray.get(i));
        holder.mFullname.setText( nameArray.get(i));


    }