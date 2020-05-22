public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

            if(holder instanceof PostViewHolder){
                int index = position - position / 2;
                PostCard post = mData.get(index);

                ((PostViewHolder) holder).postcard_name.setText(post.name);
                ((PostViewHolder) holder).postcard_time.setText(post.time);
                ((PostViewHolder) holder).postcard_postText.setText(post.postText);
                ((PostViewHolder) holder).postcard_likes.setText(post.likes);
                ((PostViewHolder) holder).postcard_comments.setText(post.comments);
                Glide.with(mContext)
                        .load(post.userIconUrl)
                        .into(((PostViewHolder) holder).postcard_userIcon);
                Glide.with(mContext)
                        .load(post.postPicUrl)
                        .into(((PostViewHolder) holder).postcard_postPic);
            }

            ...
}