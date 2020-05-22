private void initRecyclerViewData(){

   List<SampleData> data = new ArrayList<>();

   data.add(new DataObject("Title of row 1", menuIcons[0]));
   data.add(new DataObject("Title of row 2", menuIcons[1]));
   data.add(new DataObject("Title of row 3", menuIcons[2]));
   data.add(new DataObject("Title of row 4", menuIcons[3]));

   //now initialize your adapter - we will create the adapter next
   mAdapter = new SampleRecyclerAdapter(data);
   mRecyclerView.setAdapter(mAdapter);
   mAdapter.notifyDataSetChanged();
}