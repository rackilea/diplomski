check_list_item.setOnClickListener(new View.OnClickListener() { 
    @Override 
    public void onClick(View v) {
        mActivityAdapterInterface.prepareSelection(v, getAdapterPosition());
    } 
});