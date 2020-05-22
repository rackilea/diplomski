// Get listview
ListView lv = getListView();
tourNumberListAdapter = new TourNumberListAdapter(this, cursorTourNumberInfo);
setListAdapter(tourNumberListAdapter);

lv.setOnItemClickListener(new OnItemClickListener() {