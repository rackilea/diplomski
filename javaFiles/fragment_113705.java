DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Driver");

reference.orderByKey().equalTo("1815000000").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot datas: dataSnapshot.getChildren()){
            String driver_name = datas.child("d_nme").getValue(String.class);
            String driver_avator = datas.child("d_avtr").getValue(String.class);
            String vehicle_no = datas.child("v_No").getValue(String.class);
            String vehicle_name = datas.child("v_nme").getValue(String.class);
            String vehicle_type = datas.child("v_tpe").getValue(String.class);
        }
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});