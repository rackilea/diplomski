public class FooInfoViewHolder extends RecyclerView.ViewHolder {

        @OnClick
        public void onClick(View v) {
            int selectedPosition = recyclerView.getChildAdapterPosition(v);
            mapView.onFooSelected(foos.get(selectedPosition));
        }

        public FooInfoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }