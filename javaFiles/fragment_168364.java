public void setUpRecyclerView() {
    RecyclerView list = findViewById(R.id.apps_list);

    list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    SpecialAdapter adapter = new SpecialAdapter(apps,this);
    adapter.setClickListener(this);
    list.setAdapter(adapter);

}