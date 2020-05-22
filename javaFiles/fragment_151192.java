ArrayList<String> list = new ArrayList<>();
list.add("something1");
list.add("something2");

RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rec);
recyclerView.setHasFixedSize(true);

LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
recyclerView.setLayoutManager(linearLayoutManager);

MenuRecAdapter menuRecAdapter = new MenuRecAdapter(list);
recyclerView.setAdapter(menuRecAdapter);