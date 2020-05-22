@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_my, container, false);
    ListView lview = (ListView)view.findViewById(R.id.listview);
    populateList();
    listviewAdapter adapter = new listviewAdapter(getActivity(), list);
    lview.setAdapter(adapter);
    return view;
}