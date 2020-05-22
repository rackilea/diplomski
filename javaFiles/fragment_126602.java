private static final String TAG = MainActivity.class.getSimpleName();

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("qrCode");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRef.addChildEventListener(new MyChildEventListener());


    }

   public void deleteValueFromDb(View view){

    myRef.child("data").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                dataSnapshot.getRef().removeValue();

            }else{
                Toast.makeText(getApplicationContext() , "Not Done", Toast.LENGTH_LONG).show();
            }
        }

         @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
             throw databaseError.toException();
         }
     });
   }

private class MyChildEventListener implements ChildEventListener {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        Log.i(TAG, "childAdded " + dataSnapshot.toString());
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        Log.i(TAG, "childChanged " + dataSnapshot.toString());
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        Log.i(TAG, "childRemoved " + dataSnapshot.toString());
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        Log.i(TAG, "childMoved " + dataSnapshot.toString());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.i(TAG, "childMoved " + databaseError.getMessage());
    }
}