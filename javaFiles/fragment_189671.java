view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(mContext, FavouritesContentActivity.class);
        intent.putExtra("actionBarTitle", modellist.get(i).getTitle());
        intent.putExtra("contentTv", modellist.get(i).getDesc());
        mContext.startActivity(intent);
     }
});