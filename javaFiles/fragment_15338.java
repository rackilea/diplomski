private ListView listView = null;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);

    int scnum = getArguments().getInt(ARG_SECTION_NUMBER);

    listView = (ListView) rootView.findViewById(R.id.products_list);

    refreshListView();

    return rootView;
}

public void refreshListView() {
    // here refresh your listView trough internet
}