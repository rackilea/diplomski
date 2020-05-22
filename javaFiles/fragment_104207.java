public class ListActivityFragment extends ListFragment implements OnItemClickListener{

    static final String[] CLASSES = { "Government", "Hawaiian History", "Economics", "Psychology"};
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_layout, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListAdapter(new ClassAdapter(getActivity(), CLASSES));
        getListView().setOnItemClickListener(this);

    }

     @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // do dome thing with 'position'.
    }
}