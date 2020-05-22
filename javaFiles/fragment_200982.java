ItemClickListener listener = new ItemClickListener(){
    @Override
    public void onItemClicked(RecyclerView.ViewHolder vh, Object item, int pos){
        Toast.makeText(getActivity(), "Item clicked: " + pos, Toast.LENGTH_SHORT).show();
    }
};