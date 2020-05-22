@Subscribe(threadMode = ThreadMode.MAIN)
    public void onParentEventClicked(ParentAdapter.ParentEvent event) {
// to access the inner adapter here you must set it to public in the ParentAdapter(public ChildAdapter adapter;)
        adapter.adapter.deSelectChild();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onChildEventClicked(ChildAdapter.ChildEvent event) {
// normal ParentAdapter reference(ParentAdapter adapter;)
        adapter.deSelectParent();
    }