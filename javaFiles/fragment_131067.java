@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View rootView = inflater.inflate(R.layout.fragment_resultspage, container, false);
    ListView myListView = (ListView) rootView.findViewById(R.id.resultsView);
    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), 
                                     android.R.layout.simple_list_item_1, 
                                                               YOUR_RESULT);
    myListView.setAdapter(arrayAdapter);
    return rootView;
}