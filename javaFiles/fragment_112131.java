public class RidesFragment extends Fragment {

    ListView list;
    RidesAdapter2 ridesAdapter;
    List<Ride> rides;
    Ride ride;

    List<RidePojo> filteredRides;
    LinearLayout layoutFilter;
    boolean filtersVisible = false;
    boolean searchDone = false;

    String userNumber;

    public RidesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rides, container, false);
        getActivity().setTitle("Search for a ride:");

        // filter action button stuff
        setHasOptionsMenu(true);
        layoutFilter = rootView.findViewById(R.id.ll_filter_screen);

        /*FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);*/




        Bundle arguments = getArguments();
        list = rootView.findViewById(R.id.rides_list);
        rides = new ArrayList<>();
        ridesAdapter = new RidesAdapter2(getContext(), rides);
        list.setAdapter(ridesAdapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("rides");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot: dataSnapshot.getChildren()) {
                    Ride ride = singleSnapshot.getValue(Ride.class);
                    rides.add(ride);
                    ridesAdapter.notifyDataSetChanged();
                    Log.d("FbDatabase", singleSnapshot.toString());
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        //rides.add(ride);

        // In case the rides ArrayList is not empty another fragment appears for no rides criteria
        if(rides.isEmpty()) {
            rootView = inflater.inflate(R.layout.fragment_empty, container, false);
            Button rideButton = rootView.findViewById(R.id.btn_post_ride);
            Button requestButton = rootView.findViewById(R.id.btn_post_request);

            rideButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchFragment(new OfferRideFragment(), getActivity());
                }
            });

            requestButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchFragment(new RequestFragment(), getActivity());
                }
            });

        }

        //else {
            //list.setAdapter(ridesAdapter);

        //}
        return rootView;
    }

    protected void launchFragment(Fragment f, FragmentActivity a) {
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                a.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, f);
        fragmentTransaction.commit();
    }
// ....
}