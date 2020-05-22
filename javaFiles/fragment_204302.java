@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView  = inflater.inflate(R.layout.fragment_main, container, false);
    ListView lv = (ListView) rootView.findViewById(R.id.messagesList);

    String [] messages = new String[]{
            "Item 1", 
            "Item 2", 
            "Item 3", 
            "Item 4" 
    }; 


    ArrayAdapter<String> adapter;
    adapter = new ArrayAdapter<>(
            getActivity(), 
            R.layout.message_item,
            messages);

    lv.setAdapter(adapter);
    return rootView;
}