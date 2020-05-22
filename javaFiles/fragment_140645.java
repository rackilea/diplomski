mBinding.movieDetailReviewListRvReviews.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // Load more data if reached the end of the list
                adapter.checkForHide(layoutManager.findFirstVisibleItemPosition(), layoutManager.findLastVisibleItemPosition());

                if (layoutManager.findLastVisibleItemPosition() == adapter.reviewList.size() - 1 && !isLoadingLocked && !isLoading) {
                    if (pageToDownload < totalPages) {
                        mBinding.layoutContent.pbLoadingMore.setVisibility(View.VISIBLE);
                        downloadMovieReviews();
                    }
                }
            }
        });