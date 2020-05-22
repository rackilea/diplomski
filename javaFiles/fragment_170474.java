gridRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
        @Override
        public void onScrolled(RecyclerView recyclerView, int x, int y)
        {
            super.onScrolled(recyclerView, x, y);
            GridView_Holder gridHolder;
            gridHolder= (GridView_Holder) recyclerView.findViewHolderForPosition(adapter.mCurrentSelectedPosition);
            if (gridHolder != null && gridHolder.itemView != null) {
                   gridHolder.itemView.setSelected(true);
            }
        }
}