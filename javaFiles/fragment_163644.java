public class Bamanual extends Fragment {
    ListView listView;
    ArrayList<HashMap<String, String>> list_data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bamanual, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView1);
        return rootView;
    }