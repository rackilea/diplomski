class FeaturedView extends RecyclerView.ViewHolder {

    ...

    FeaturedView(@NonNull View itemView) {
        ...
        img_wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ...
              // save the selected state
              mSparseBooleanArray.put(getAdapterPosition(), true);

            }
         ...
    }
}