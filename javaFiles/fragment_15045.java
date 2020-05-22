@Override
public void onBindViewHolder(@NonNull viewholder holder, int position) {
    Product product = productList.get(position);
            //loading the image
            Glide.with(mCtx)
                    .load(product.getImage())
                    .into(holder.imageView);
            holder.textViewTitle.setText(product.getTitle());
            holder.textViewShortDesc.setText(product.getShortdesc());

    holder.textViewPrice.setText(String.valueOf(product.getPrice()));
    final Product p=product ;
    holder.itemView.setOnClickListener(new OnClickListener() {
    public void onClick(View v) {

    Intent intent=new Intent(mCtx,InfoPage.class);
    intent.putExtra("prod_id",p.getID());
    intent.putExtra("prod_title",p.getTitle());
    startActivity(intent);

}});

}