//make this a separate class,but not inside the onBindViewHolder
private class NativeExpressAdViewHolder extends RecyclerView.ViewHolder{
    NativeExpressAdViewHolder(View view){                            
    super(view);
    //find the view here
    adView = (NativeExpressAdView)view.findViewById(R.id.native_ad);
}

private class RecyclerViewHolder extends RecyclerView.ViewHolder{
   //this one as usual..
}



//change your onCreateViewHolder for this as well,
// cause now you have 2 view type,so you just override from universal 
//RecyclerView.ViewHolder,not need RecyclerViewAdapter.RecyclerViewHolder
   @Override
     public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { }




@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    int viewType = getItemViewType(position);
    switch (viewType){
      case AD_VIEW_TYPE:
      final NativeExpressAdViewHolder adHolder (NativeExpressAdViewHolder)holder
       //here find your view and load the ad


     break;
     case MENU_ITEM_VIEW_TYPE:
     final  RecyclerViewHolder viewHolder = (RecyclerViewHolder)holder
     //do your thing here,find view,assign value to the layout

    }