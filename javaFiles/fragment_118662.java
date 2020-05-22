@Override
 protected void onStart() {
super.onStart();
  dealList.clear();
rootRef.child(expertId).child("Cooker Deals").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        for(DataSnapshot dealSnapshot : dataSnapshot.getChildren()){
         for(DataSnapshot datas : dealSnapshot.getChildren(){
             NewDeal_Database info = datas.getValue(NewDeal_Database.class);
            dealList.add(info);



        }

        DealList adapter = new DealList( New_Deal_List.this,dealList);
        lvDealList.setAdapter(adapter);
        adapter.notifydatasetchanged();
    }