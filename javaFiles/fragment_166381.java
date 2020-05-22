Database database = FirebaseDatabase.getInstance();
 DatabaseReference databaseReference = database.getReference("");
 databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        Pojo pojo = dataSnapshot.getValue(Pojo.class);
        Gson gson = new Gson();
        String reqJson= gson.toJson(pojo);
        return reqJson
    }