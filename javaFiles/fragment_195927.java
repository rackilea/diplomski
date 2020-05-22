public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
        System.out.println(userSnapshot.getKey());
        for (DataSnapshot dealSnapshot: userSnapshot.child("Deals").getChildren()) {
            System.out.println(dealSnapshot.getKey());
        }
    }
}