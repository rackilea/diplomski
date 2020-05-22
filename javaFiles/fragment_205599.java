public interface ItemClickListener {
    void onItemClick(View view, int position);
 }

ItemClickListener listener;

public void setItemClickListener(ItemClickListener listener){
   this.listener = listener;
}

@Override 
 public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
    ViewHolder viewHolder =  new ViewHolder(v);
    viewHolder.setItemClickListener(listener);
    return viewHolder;
 }