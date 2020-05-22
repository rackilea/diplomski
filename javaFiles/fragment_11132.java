myRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            int itemPosition=linearLayoutManager.findFirstCompletelyVisibleItemPosition();

            if(itemPosition==0){ //  item position of uses
                TabLayout.Tab tab = myTabLayout.getTabAt(Index);
                tab.select();
            }else if(itemPosition==1){//  item position of side effects 
                TabLayout.Tab tab = myTabLayout.getTabAt(Index);
                tab.select();
            }else if(itemPosition==2){//  item position of how it works
                TabLayout.Tab tab = myTabLayout.getTabAt(Index);
                tab.select();
            }else if(itemPosition==3){//  item position of precaution 
                TabLayout.Tab tab = myTabLayout.getTabAt(Index);
                tab.select();
            }
        }
    });