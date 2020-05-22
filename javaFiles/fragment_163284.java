SnapOnScrollListener snapOnScrollListener = new SnapOnScrollListener(
                    snapHelper,
                    SnapOnScrollListener.Behavior.NOTIFY_ON_SCROLL,
                    position -> {   
Log.e(TAG, "currently focused page no = "+position);    
// your code here, do whatever you want
}
            );

            childRecyclerView2.addOnScrollListener(snapOnScrollListener);