private void initViews(int tcpcount){
        String base = "CASSA SELF N°";
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerviewSelfMachine);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        selfList = new ArrayList<>();
        for (int i=0; i < tcpcount; i++) {
            selfList.add(base + Integer.toString(i+1));
        }
        RecyclerView.Adapter adapter = new RecyclerViewSelf(selfList);
        recyclerView.setAdapter(adapter);
    }