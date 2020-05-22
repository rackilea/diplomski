@Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if(position>=getItemCount()-1 && isMoreDataAvailable && !isLoading && loadMoreListener!=null){
            isLoading = true;
            loadMoreListener.onLoadMore();
        }
        if(getItemViewType(position)==TYPE_MOVIE){
            MovieHolder movieHolder = (MovieHolder) holder;
            movieHolder.bindData(movies.get(position));

            // tvRating
            movieHolder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, ""+ position, Toast.LENGTH_LONG)
                            .show();
                }
            });
        }        
    }