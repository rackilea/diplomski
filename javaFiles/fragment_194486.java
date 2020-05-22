databasedeposit.addListenerForSingleValueEvent (new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        abc.clear();
        Integer total = 0;
        Integer n_total=0;

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            ADeposit bazar = ds.getValue(ADeposit.class);
            Integer cost = Integer.valueOf(bazar.getAmount());
            total = total + cost;
            abc.add(bazar);

            if ("Rabbani".equals(ds.child("name").getValue(String.class)) {
                n_total = n_total + cost;
            }
        }

        System.out.println("total: "+total+", n_total: "+n_total);

        ...

    }


    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
}); ;