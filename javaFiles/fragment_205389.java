public void searchList() {

     if (searchList == null) {
         searchList = new ArrayList<>();
     } else {
         searchList.clear();
     }

     for (int i = 0; i < valueList.size(); i++) {
       ...
     }

     mAdapter = new MainAdapter(searchList, R.layout.card_row, getApplicationContext());
     mRecyclerView.setAdapter(mAdapter);

}