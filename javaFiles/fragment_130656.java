// Create an instance of SectionedRecyclerViewAdapter 
SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();

// Create your sections with a sub list of data from mData
MySection data1Section = new MySection("First 10 elements start", categories1List);
MySection data2Section = new MySection("Elements from 10 to 20 start", categories2List);
MySection data3Section = new MySection("Elements from 20 to 30 start", categories3List);

// Add your Sections to the adapter
sectionAdapter.addSection(data1Section);
sectionAdapter.addSection(data2Section);
sectionAdapter.addSection(data3Section);

// Set up your RecyclerView with the SectionedRecyclerViewAdapter
RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
recyclerView.setAdapter(sectionAdapter);