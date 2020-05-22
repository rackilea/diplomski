public class MyAdapter extends BaseAdapter
  {
   ArrayList<String> items;
    public void Myadapter(ArrayList<String> items)
     {
    this.items=items;
    }
   //override methods

     @Override
      public View getView(final int position, View convertView, ViewGroup         
       parent) {
      ViewHolder holder;
       if (convertView == null) {
    convertView =        
    LayoutInflater.from(getContext()).inflate(R.layout.item_grid, null);
     holder = new ViewHolder(convertView);
    convertView.setTag(holder);
     } else {
    holder = (ViewHolder) convertView.getTag();
     }
      holder.build(getItem(position).toString());
      deleteView = convertView.findViewById(R.id.delete_markView);
     deleteView.setVisibility(isShowDelete ? View.VISIBLE : View.GONE);
    deleteView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        removeItemInShared(items.get(position));
        items.remove(position);

        Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
    }
});
return convertView;
}