public class FragmentList extends ListFragment {

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        String[] stringa = {"A","B","C"};

        ListView listView = (ListView) rootView.findViewById(android.R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,stringa);
        listView.setAdapter(arrayAdapter);

        return rootView;
    }
}