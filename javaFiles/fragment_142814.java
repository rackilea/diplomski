@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {         
    View rootView = inflater.inflate(R.layout.fragment_home, container, false);
    listView = (ListView) rootView.findViewById(R.id.list);
    return rootView;
}