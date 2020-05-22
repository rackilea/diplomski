RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
  @Override
  public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                                   super.onScrollStateChanged(recyclerView, newState);
      if (newState == RecyclerView.SCROLL_STATE_IDLE) {
          RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder)
                mRecyclerView.findViewHolderForAdapterPosition(replyPosition);
                      if(holder != null) {
                           View view = holder.itemView.findViewById(R.id.selected);
                           view.setVisibility(View.VISIBLE);
                           view.startAnimation(AnimationUtils.loadAnimation(mActivity,
                                                   R.anim.fade_out));

                                       }

                                   }
                               }

  @Override
  public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
  }
                           };
  mRecyclerView.addOnScrollListener(listener);
  mRecyclerView.smoothScrollToPosition(replyPosition);