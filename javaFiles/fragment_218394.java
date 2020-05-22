ExpandableListView expListView;
@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    expListView = (ExpandableListView) getActivity().findViewById(R.id.exLstItems);
    final ExpandableListAdapter expListAdapter = new ItemsExpandableListAdapter(getActivity(), groupItemList, ItemCollection);
    expListView.setAdapter(expListAdapter);

    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

        @Override
        public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
            if (groupPosition == 0){
                if (childPosition == 0){
                }
            }
         }
    });
}