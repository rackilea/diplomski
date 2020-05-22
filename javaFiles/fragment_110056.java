@Override
public void onBindViewHolder(@NonNull final BookViewHolder holder, final int position) {
  final Context context = holder.itemView.getContext();

  Picasso.with(context)
    .load(bookList.get(position).Link)
    .into(holder.img_product);
}