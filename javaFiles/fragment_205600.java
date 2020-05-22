public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
public TextView myTextView;
public ImageView myImage;
MyRecyclerViewAdapter.ItemClickListener itemClickListener;

ViewHolder(View itemView) {
    super(itemView);
    myTextView = (TextView) itemView.findViewById(R.id.info_text);
    myImage = (ImageView) itemView.findViewById(R.id.image_test);
    itemView.setOnClickListener(this);
}

@Override
public void onClick(View view) {
    if (itemClickListener != null) itemClickListener.onItemClick(view, getAdapterPosition());
 }


void setItemClickListener(MyRecyclerViewAdapter.ItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
 }


  String getItem(int id){
    return mData[id];
   }
}