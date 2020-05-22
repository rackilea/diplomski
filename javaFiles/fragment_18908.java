class AdsViewHolder extends RecyclerView.ViewHolder {

    ImageView img_avatar;
    CardView CV_item;
    AdsViewHolder(View itemView) {
        super(itemView);
        //-----------------------------------------------------------
        img_avatar = (ImageView) itemView.findViewById(R.id.img_avatar);
        CV_item = (CardView) itemView.findViewById(R.id.cardView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemSelected=getAdapterPosition();
                notifyDataSetChanged();
            }
        });

    }

}