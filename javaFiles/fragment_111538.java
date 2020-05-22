RecyclerView recyclerView = view.findViewById(R.id._events_recyclerview);

ADAPTE_CLASS adapter = new ADAPTE_CLASS(PASS DATA IF NECESSARY);

recyclerView.setAdapter(adapter);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));