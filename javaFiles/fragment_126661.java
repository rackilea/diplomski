@Override
public void onBindViewHolder(WebsiteAdapter.ViewHolder holder, int position) {
   Website website = mDataSource.get(position);
   holder.url.setText(website.getUrl());
   holder.thumbnailImageView.setImageResource(getDrawable(website.getUrl()));
}