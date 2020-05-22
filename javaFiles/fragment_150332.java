@Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        ProductInfo productInfo = mProductList.get(position);
        holder.mProductName.setText(productInfo.getProductName());
        holder.mProductPrice.setText(productInfo.getProductPrice());
        //holder.mProductRating.setText(productInfo.getProductRating());


        Picasso.get()
                .load(productInfo.getProductImage())
                .into(holder.mProductImage);

//new code - start here
holder.anyuielementInItem.setOnClickListener(new View.OnClickListener() { 
        @Override
        public void onClick(View view) 
        { 
            // Do things you want
        } 
    }); 

//

    }