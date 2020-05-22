public class ParksFragment extends Fragment {

private ArrayList<Park> parks = new ArrayList<>();
parkArrayAdapter adapter;

public ParksFragment() {
    // Required empty public constructor
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

View rootView = inflater.inflate(layout.fragment_parks, container, false);

...

 ListView listView = (ListView)rootView.findViewById(R.id.customListView);
    listView.setAdapter(adapter);
 return rootView;