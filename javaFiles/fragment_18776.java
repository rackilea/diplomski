public class StoreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

public TextView txtStoreName;
public ImageView imageView;
Context context;

private ItemClickListener itemClickListener;

public StoreViewHolder(View itemView, Context context) {
    super(itemView);
    this.context = context;
    txtStoreName = (TextView) itemView.findViewById(R.id.store_name);
    imageView = (ImageView) itemView.findViewById(R.id.store_image);

    itemView.setOnClickListener(this);
}

public void setItemClickListener(ItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
}


@Override
public void onClick(View view) {
    itemClickListener.onClick(view, getAdapterPosition(), false);
    Intent categoryList = new Intent(view.getContext(), CategoryList.class);
    context.startActivity(categoryList); // does not compile here
}
}