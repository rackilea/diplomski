public class Tab1Buy extends Fragment {
private DatabaseReference propertyRef;
private RecyclerView mPropertyRecyclerView;
FirebaseRecyclerAdapter<Property, PropertyViewHolder> mPropertyAdapter;


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.property_tab, container, false);
    mPropertyRecyclerView = rootView.findViewById(R.id.property_recyclerView);
    return rootView;
}


//TODO Check internet and display error msg if internet down
@Override
public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mPropertyRecyclerView.hasFixedSize();
    mPropertyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    final ProgressBar progressBar = view.findViewById(R.id.progressBar);
    progressBar.setVisibility(View.VISIBLE);

    propertyRef = FirebaseDatabase.getInstance()
            .getReference()
            .child("Buy");
    propertyRef.keepSynced(true);

    // keyQuery - the Firebase location containing the list of keys to be found in dataRef
    //Query personQuery = propertyRef.orderByKey();


    FirebaseRecyclerOptions<Property> options =
            new FirebaseRecyclerOptions.Builder<Property>()
                    .setQuery(propertyRef, Property.class)
                    .build();

    mPropertyAdapter = new FirebaseRecyclerAdapter<Property, PropertyViewHolder>(options) {


        @Override
        // Bind the Property object to the ViewHolder PropertyHolder
        public void onBindViewHolder(@NonNull PropertyViewHolder holder,
                                     final int position, @NonNull final Property model) {
            holder.setPrice(model.getPrice());
            holder.setAddress(model.getAddress());
            holder.setNumberOfBed(model.getNumberOfBed());
            holder.setNumberOfBath(model.getNumberOfBath());
            holder.setNumberOfCar(model.getNumberOfCar());
            holder.setPropertyImage(model.getPropertyImage());

        //This Intent send Parcelable from Property to PropertyDetail
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), PropertyDetail.class)
                .putExtra("Property", model));

            }
        });


        }

        @Override
        public PropertyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // Create a new instance of the ViewHolder, in this case we are using a custom
            // layout called R.layout.property_card for each item
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.property_card, parent, false);
            return new PropertyViewHolder(view);

        }

        @Override
        public void onDataChanged() {
            // Called each time there is a new data snapshot. You may want to use this method
            // to hide a loading spinner or check for the "no documents" state and update your UI.
            // ...
            progressBar.setVisibility(View.GONE);
        }

        //TODO Implement onError
        @Override
        public void onError(@NonNull DatabaseError e) {
            // Called when there is an error getting data. You may want to update
            // your UI to display an error message to the user.
            // ...
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getActivity(), "DatabaseError", Toast.LENGTH_SHORT).show();
        }

    };
    mPropertyRecyclerView.setAdapter(mPropertyAdapter);



}

@Override
public void onStart() {
    super.onStart();
    mPropertyAdapter.startListening();
}

@Override
public void onStop() {
    super.onStop();
    mPropertyAdapter.stopListening();
}


public class PropertyViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public PropertyViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setPrice(int price) {
        String currencyPrice = NumberFormat //Format the price variable in currency form
                .getCurrencyInstance(Locale.US)
                .format(price);
        TextView Price = mView.findViewById(R.id.post_price);
        Price.setText(currencyPrice);
    }

    public void setAddress(String address){
        TextView Address = mView.findViewById(R.id.post_address);
        Address.setText(String.valueOf(address));
    }

    public void setNumberOfBed(int numberOfBed){
        TextView NumberOfBed = mView.findViewById(R.id.post_bedroom);
        NumberOfBed.setText(String.valueOf(numberOfBed));
    }

    public void setNumberOfBath(int numberOfBath){
        TextView NumberOfBath = mView.findViewById(R.id.post_bathroom);
        NumberOfBath.setText(String.valueOf(numberOfBath));
    }

    public  void  setNumberOfCar(int numberOfCar) {
        TextView NumberOfCar = mView.findViewById(R.id.post_garage);
        NumberOfCar.setText(String.valueOf(numberOfCar));
    }

    public void setPropertyImage(String propertyImage){
        ImageView imageView = mView.findViewById(R.id.post_propertyImage);

        //take one long string containing multiple url in and parse it
        String propertyImageArray[] = propertyImage.split(",");

        //Loading circle for placeholder, ColorAccent has been used
        CircularProgressDrawable progressDrawable =
                new CircularProgressDrawable(getContext());
        progressDrawable.setStrokeWidth(5f);
        progressDrawable.setCenterRadius(30f);
        progressDrawable.setColorSchemeColors(Color.argb(1,255,145,0));
        progressDrawable.start();

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        GlideApp.with(getContext())
                .load(propertyImageArray[0])
                .placeholder(progressDrawable)
                .fitCenter()
                .into(imageView);
    }
}

}