private void updateUI() {
    PeopleLab peopleLab = PeopleLab.get(getActivity());
    List<People> peoples = peopleLab.getPeople();

    if(mAdapter == null) {
        mAdapter = new PeopleAdapter(peoples);
        mRecyclerView.setAdapter(mAdapter);
    } else {
        // You actually have to change your dataset
        mAdapter.changeDataSet(peoples);
    }
}