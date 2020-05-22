public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

// add this line
private AdapterView.OnItemClickListener onItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ImageView image;
            private TextView text;
            FragmentNewsItems fragmentNewsItems = new FragmentNewsItems();


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image);
                text = itemView.findViewById(R.id.text);

                itemView.setOnClickListener(this);
            }

      @Override
            public void onClick(View view) {
                mAdapter.onItemHolderClick(ViewHolder.this);
            }

        }

        public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        private void onItemHolderClick(ViewHolder holder) {
            if (onItemClickListener != null)
                onItemClickListener.onItemClick(null, holder.itemView, holder.getAdapterPosition(), holder.getItemId());
        }
}