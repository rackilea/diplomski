myAd.layout.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                   ...
                                   row = myAd.adapterPosition();
                                   notifyDataSetChanged();