public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView ItemPriceRecycler,ItemNameRecycler,ItemQuantityRecycler;
        public RecyclerViewHolder(View view)
        {
            super(view);
            ItemNameRecycler=(TextView)view.findViewById(R.id.RowItemName);
            ItemPriceRecycler=(TextView)view.findViewById(R.id.RowItemPrice);
            ItemQuantityRecycler=(TextView)view.findViewById(R.id.RowItemQuantity);
            ItemQuantityRecycler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // get position
                    int pos = getAdapterPosition();  //get position here
                }
            });
        }