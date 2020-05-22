mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot child: dataSnapshot.getChildren()) {
            String type = child.getChild("type").getValue(String.class);
            if ("Child1".equals(type)) {
                Child1 child1 = child.getValue(Child1.class);
            }...
        }
    }