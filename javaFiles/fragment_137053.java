@Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            if (holder instanceof DataViewHolder) {
                ((DataViewHolder) holder).countryListTxt.setText(mData.get(position).getName() + "");
                ((DataViewHolder) holder).countryListTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "" + mData.get(position).getId(), Toast.LENGTH_SHORT).show();
                        listner.onListSelected(position);
                    }
                });
            }
        }