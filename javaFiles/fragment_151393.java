yourListView.setAdapter(yourAdapter);
    yourListView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
            YourItemClass itemClicked = view.yourGetData();
            yourAdapter.changeIcon(itemClicked);
        }
    });