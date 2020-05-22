.......
@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chat);
    ........
    mRootRef = FirebaseDatabase.getInstance().getReference();
    .......
    mRootRef.child("Chat").child(current_uid)
    .addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
        .........