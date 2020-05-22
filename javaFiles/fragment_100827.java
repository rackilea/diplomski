@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    int num = getArguments().getInt(ARG_SECTION_NUMBER);
    records = dao.getAllRecords();
    mAdapter = new TimetableAdapter(getActivity(),  records);
    listView.setAdapter(mAdapter);
}