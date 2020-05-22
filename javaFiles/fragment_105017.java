@Override
public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

     if (mDelegateOnScrollListener != null) { // delegate
          mDelegateOnScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
     }

     if(firstVisibleItem+visibleItemCount == totalItemCount && totalItemCount!=0)
     {
         if(context!=null){
            ((PinnedSectionListActivity)context).cleans();
         }
     }else {
            // get expected adapter or fail fast
            ListAdapter adapter = getAdapter();
            if (adapter == null || visibleItemCount == 0) return; // nothing to do

                final boolean isFirstVisibleItemSection = isItemViewTypePinned(adapter, adapter.getItemViewType(firstVisibleItem));

                if (isFirstVisibleItemSection) {
                    View sectionView = getChildAt(0);
                    if (sectionView.getTop() == getPaddingTop()) { // view sticks to the top, no need for pinned shadow
                        destroyPinnedShadow();
                    } else { // section doesn't stick to the top, make sure we have a pinned shadow
                        ensureShadowForPosition(firstVisibleItem, firstVisibleItem, visibleItemCount);
                    }

                } else { // section is not at the first visible position
                    int sectionPosition = findCurrentSectionPosition(firstVisibleItem);
                    if (sectionPosition > -1) { // we have section position
                        ensureShadowForPosition(sectionPosition, firstVisibleItem, visibleItemCount);
                    } else { // there is no section for the first visible item, destroy shadow
                        destroyPinnedShadow();
                    }
                }
    }
};