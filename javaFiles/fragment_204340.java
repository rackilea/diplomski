firebaseRef.child(single_view).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
ListItem data = dataSnapshot.getValue(ListItem.class);
                listItems.add(data);
                adapter.notifyDataSetChanged();
        //if you are accessing your data from a ListView