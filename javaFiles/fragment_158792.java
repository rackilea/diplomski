fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            layoutManager.scrollToPosition(yourlist.size() - 1);
        }
    });

   rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            if (layoutManager.findLastVisibleItemPosition() < yourlist.size() - 1) {
                fab.setVisibility(View.VISIBLE);
            } else
                fab.setVisibility(GONE);
            super.onScrolled(recyclerView, dx, dy);
        }
    });