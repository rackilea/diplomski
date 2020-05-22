grid.setOnScrollListener(new AbsListView.OnScrollListener() {
        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            //Log.d("Onboarding 7331", "onScroll: onScroll " + firstVisibleItem + " " + selectedPositions.toString());
            for (int i = 0; i < totalItemCount; i++) {
                View tv = grid.getChildAt(i - firstVisibleItem);
                if (tv == null) {
                    continue;
                }
                if (selectedPositions.contains(Integer.toString(i))) {
                    tv.setBackgroundColor(Color.parseColor("#FFE5CD"));
                } else {
                    tv.setBackgroundColor(Color.parseColor("#EEEEEE"));
                }
            }
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
            //     Log.d("Onboarding 7331", "onScroll: state changed "+selectedPositions.toString());
        }
    });