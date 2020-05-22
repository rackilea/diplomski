public void onBindViewHolder(ViewHolder holder, int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    //holder.mTextView.setText(mDataset.get(position).getName());
    Log.d("TEST","Printing Names onBindView 
     Holder"+mDataset.get(position).getName());
    holder.nameText.setText(mDataset.get(position).getName());
    holder.phoneText.setText(mDataset.get(position).getPhone());
    holder.image.setImageUrl(mDataset.get(position).getImage(),mImageLoader);

    holder.image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) 
{
     context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(UrlsToTran.get(position).toString())));

}
    });

}