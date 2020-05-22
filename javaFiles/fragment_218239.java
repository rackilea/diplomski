private void loadItemsData() {
    RecyclerView itemsRecyclerView = view.findViewById(R.id.posts_recycler_view);
    itemsRecyclerView.setHasFixedSize(true);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    itemsRecyclerView.setLayoutManager(layoutManager);

    ItemAdapter myadapter = new ItemAdapter(new ArrayList<MyItem>(), getContext());

    myadapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, PostItems items) {
            ViewItem.passingIntent(getActivity(), items.postid);
        }
    });

    itemsRecyclerView.setAdapter(ListAdapter );
}