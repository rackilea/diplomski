FirebaseRecyclerAdapter<AllUsers, UsersViewHolder> firebaseRecyclerAdapter;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

    mProgressDialogue = new ProgressDialog(getActivity());
    mProgressDialogue.setMessage("Loading...");
    mProgressDialogue.show();

    noUsersText = (TextView) rootView.findViewById(R.id.noUsersText);
    mUsersList = (RecyclerView) rootView.findViewById(R.id.usersList);

    mAuth = FirebaseAuth.getInstance();
    currentUser = mAuth.getCurrentUser();
    UID = mAuth.getCurrentUser().getUid();

    mUsersList.setHasFixedSize(true);
    mUsersList.setLayoutManager(new LinearLayoutManager(getActivity()));

    mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

    FirebaseRecyclerOptions<AllUsers> options =
            new FirebaseRecyclerOptions.Builder<AllUsers>()
                    .setQuery(mDatabaseReference, AllUsers.class)
                    .build();

    firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<AllUsers, UsersViewHolder>(options) {
        @Override
        public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { }

        @Override
        protected void onBindViewHolder(@NonNull UsersViewHolder holder, int position, @NonNull AllUsers model) { }
    };
    mUsersList.setAdapter(firebaseRecyclerAdapter);

    return rootView;
}

@Override
protected void onStart() {
    super.onStart();
    firebaseRecyclerAdapter.startListening();
}

@Override
protected void onStop() {
    super.onStop();
    firebaseRecyclerAdapter.stopListening();
}