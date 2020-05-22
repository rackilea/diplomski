class Holder extends RecyclerView.ViewHolder {

        TextView t;

        public Holder(View itemView) {
            super(itemView);
            t = itemView.findViewById(R.id.text);
        }
    }