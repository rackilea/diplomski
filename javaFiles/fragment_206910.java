DatabaseReference classesRef = FirebaseDatabase.getInstance().getReference("Classes");

Query query = classesRef.orderByChild("class_info/subject").equalTo("Science");

query.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        list = new ArrayList<>();
        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
            Class_model new_class = dataSnapshot1.getValue(Class_model.class);
            ...