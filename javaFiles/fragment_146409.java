if (paramView == null) {
    // inflate a new view into paramView.
    paramView = MMWeb.this.getLayoutInflater().inflate(R.layout.grid_item, null);
 }
 // fill the paramView
 TextView localTextView = (TextView)paramView .findViewById(2131034115);
 ImageView localImageView = (ImageView)paramView .findViewById(2131034114);

 cItem = items.get(position);
 cItem.add(Integer.toString(position));
 localTextView.setText(getItemName());
 Bitmap localBitmap = d.getImage(cItem.get(3), cItem.get(2));
 localImageView.setImageBitmap(localBitmap);

 return  paramView;