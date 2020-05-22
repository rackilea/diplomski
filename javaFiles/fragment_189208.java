private View rootView;

private RecyclerView recyclerView;
private StoreAdapter storeAdapter;

private ArrayList<Store> arrayStore;

@Override
public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
    if (rootView == null) {
        rootView = inflater.inflate(R.layout.fragment_store, viewGroup, false);
        setHasOptionsMenu(false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Data");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayStore = new ArrayList<>();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Store store = snapshot.getValue(Store.class);
                    arrayStore.add(store);
                }

                storeAdapter = new StoreAdapter(getActivity() ,arrayStore);
                recyclerView.setAdapter(storeAdapter);
                Collections.shuffle(arrayStore, new Random(3));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
    return rootView;
}