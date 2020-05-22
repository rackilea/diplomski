r.addOnScrollListener(new RecyclerView.OnScrollListener() {
        public boolean top;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);


            if (top) {
                int index = mLay.findFirstVisibleItemPosition();
                r.smoothScrollToPosition(index);

            } else {
                int index = mLay.findLastVisibleItemPosition();
                r.smoothScrollToPosition(index);


            }


        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (dy > 0) {
                top = false;
            } else {

                top = true;
            }

        }
    });