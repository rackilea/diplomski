public class PlacesFragment extends Fragment {

    ArrayList<Place>           mPlaces;
    RecyclerView               mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter       mAdapter;
    Utils                      utils ; //change line


    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        utils = new Utils(getActivity());//add line

        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        mRecyclerView = rootView.findViewById(R.id.recyclerView);

        mPlaces = new ArrayList<>();

        mPlaces.add(new Place(
                utils.getStringItem("string_name"),
                "content text goes here.",
                R.drawable.img.cdd,
                4.0f
        ));

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new PlacesAdapter(mPlaces);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;

    }

}