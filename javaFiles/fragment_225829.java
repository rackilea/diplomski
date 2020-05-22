@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_city_list, container, false)

    // Replace 'android.R.id.list' with the 'id' of your RecyclerView
    mRecyclerView = (RecyclerView) view.findViewById(android.R.id.list);
    mLayoutManager = new LinearLayoutManager(this.getActivity());
    Log.d("debugMode", "The application stopped after this");
    mRecyclerView.setLayoutManager(mLayoutManager);

    mAdapter = new RecyclerAdapter(getNames());
    mRecyclerView.setAdapter(mAdapter);
    return view;
}