mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();


  final DatabaseReference locationsRef = mFirebaseDatabaseReference
            .child(USERS_CHILD.concat("/" + mFirebaseAuth.getUid()).concat("/locations"));

    FirebaseRecyclerOptions<Location> options =
            new FirebaseRecyclerOptions.Builder<Location>()
                    .setQuery(locationsRef
                            .orderByChild("name"), parser)
                    .build();


mFirebaseAdapter = new FirebaseRecyclerAdapter<Location, 
PlacesFragment.LocationViewHolder>(options) {

        @Override
        public PlacesFragment.LocationViewHolder onCreateViewHolder(ViewGroup viewGroup, 
        final int position) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            PlacesFragment.LocationViewHolder holder = new 
            PlacesFragment.LocationViewHolder(inflater.inflate(R.layout.location_item, 
            viewGroup, false));

            Log.d(TAG, "viewHolder created");

            return holder;
        }


        @Override
        protected void onBindViewHolder(final PlacesFragment.LocationViewHolder viewHolder,
                                        int position, Location location) {

            if (location.getName() != null) {
                viewHolder.locationNameTextView.setText(location.getName());
                viewHolder.locationNameTextView.setVisibility(TextView.VISIBLE);
                viewHolder.locationAddressTextView.setText(location.getAddress());

viewHolder.locationLatTextView.setText(String.valueOf(location.getLatitude()));

viewHolder.locationLongTextView.setText(String.valueOf(location.getLongitude()));
            }

        }

        @Override
        public int getItemCount() {
            int count = super.getItemCount();
            return count;

        }

        @Override
        public void onDataChanged() {

            Log.d(TAG, "OnDataChanged");

            mLandmarks.clear();

            ArrayList<Location> arr = new ArrayList<Location>();

            for (int i = 0; i < mFirebaseAdapter.getSnapshots().toArray().length; i++) {
                Location loc = mFirebaseAdapter.getItem(i);
                arr.add(loc);
                mLandmarks.put(loc.getName(), new LatLng(loc.getLatitude(), 
loc.getLongitude()));
            }

           if (mService != null) {
               mService.setLocationsData(arr);
               Log.d(TAG, "onDataChanged: updating locations");
           } else {
               mService_not_updated = true;
               Log.d(TAG, "onDataChanged: not updating locations");
           }


            // Get the geofences used.
            populateGeofenceList();

            super.onDataChanged();

        }
    };

    mFirebaseAdapter.startListening();