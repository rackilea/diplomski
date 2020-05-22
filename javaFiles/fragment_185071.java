public **void** drawerCustomListViewItemRow(
        Context context,List<String> drawerItems
){
    this.context=context;
    this.drawerItems=drawerItems;
    inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}