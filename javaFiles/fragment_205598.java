MyRecyclerViewAdapter.ItemClickListener listener = new MyRecyclerViewAdapter.ItemClickListener() {
  @Override
  public void onItemClick(View view, int position) {
     Log.i("TAG","You clicked number" + position);
  }
};

adapter = new MyRecyclerViewAdapter(context,data,file_payload);
adapter. setItemClickListener( listener);