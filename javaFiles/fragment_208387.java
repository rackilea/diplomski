private void enableExpandableList() {
      listDataHeader = new ArrayList<String>();
      listDataChild = new HashMap<String, List<String>>();
    expListView = (ExpandableListView) findViewById(R.id.left_drawer);

    prepareListData(listDataHeader, listDataChild);
    listAdapter = new ExpandListAdapter(this, listDataHeader, listDataChild);
    // setting list adapter
    expListView.setAdapter(listAdapter);

    expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

        @Override
        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {
            // Toast.makeText(getApplicationContext(),
            // "Group Clicked " + listDataHeader.get(groupPosition),
            // Toast.LENGTH_SHORT).show();
            return false;
        }
    });
    // Listview Group expanded listener
    expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

        @Override
        public void onGroupExpand(int groupPosition) {
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Expanded",
                    Toast.LENGTH_SHORT).show();
        }
    });

    // Listview Group collasped listener
    expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

        @Override
        public void onGroupCollapse(int groupPosition) {
            Toast.makeText(getApplicationContext(),
                    listDataHeader.get(groupPosition) + " Collapsed",
                    Toast.LENGTH_SHORT).show();

        }
    });

    // Listview on child click listener
    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {
            // TODO Auto-generated method stub
            // Temporary code:

            // till here
            Toast.makeText(
                    getApplicationContext(),
                    listDataHeader.get(groupPosition)
                            + " : "
                            + listDataChild.get(
                            listDataHeader.get(groupPosition)).get(
                            childPosition), Toast.LENGTH_SHORT)
                    .show();
            return false;
        }
    });}