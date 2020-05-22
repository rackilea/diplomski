private FirebaseDatabase database = FirebaseDatabase.getInstance();
private final DatabaseReference myRef = database.getReference("Data"); //Init your ref at Data
myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {                       
            String lat = messageSnapshot.child("ABC").child("Lat").getValue().toString(); //acces to ABC => Lat
            Toast.makeText(getApplicationContext(), "Lat: " + lat, Toast.LENGTH_SHORT).show() //print here
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
};