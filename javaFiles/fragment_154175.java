public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView ItemPriceRecycler, ItemNameRecycler, ItemQuantityRecycler;

        public RecyclerViewHolder(final View itemView) {
            super(itemView);
            ItemNameRecycler = (TextView) itemView.findViewById(R.id.RowItemName);
            ItemPriceRecycler = (TextView) itemView.findViewById(R.id.RowItemPrice);
            ItemQuantityRecycler = (TextView) itemView.findViewById(R.id.RowItemQuantity);

            ItemQuantityRecycler.setOnClickListener(this);

        }

        // onClick Listener for view
        @Override
        public void onClick(View v) {

            if (v.getId() == ItemQuantityRecycler.getId()) {
                int pos = getAdapterPosition();
                int value = pos + 1;
                Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                ItemQuantityRecycler.setText(String.valueOf(value));
            } else {

            }
        }
    }