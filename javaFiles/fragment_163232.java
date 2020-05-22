// Create an instance of SectionedRecyclerViewAdapter 
SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();

// Create your sections with the list of data for each year
TradeSection section1 = new TradeSection(bobDataList);
TradeSection section2 = new TradeSection(jimDataList);

// Add your Sections to the adapter
sectionAdapter.addSection(section1);
sectionAdapter.addSection(section2);

// Set up your RecyclerView with the SectionedRecyclerViewAdapter
RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
recyclerView.setAdapter(sectionAdapter);