final DatabaseReference beaconMessageRef = dataSnapshot.getRef().getRoot().child("region_messages/" + regionKey);
beaconMessageRef.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot dataSnapshot) {
    if(!dataSnapshot.exists())
      FirebaseHelper.this.messageByBeaconListener.onSuccess(null);

    for (DataSnapshot regionMessageDS : dataSnapshot.getChildren()) {

      RegionMessage regionMessage = regionMessageDS.getValue(RegionMessage.class);
      String msgKey = regionMessageDS.getKey();

      final Integer[] counter = new Integer[1];
      final DatabaseReference messageRef = regionMessageDS.getRef().getRoot().child("messages/"+msgKey);
      messageRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot innerSnapshot) {
          if(innerSnapshot.exists()){
            Message msg = innerSnapshot.getValue(Message.class);
            FirebaseHelper.this.addMessageByBeacon(msg);
          }
          counter[0] = new Integer(counter[0].intValue()+1);
          if (counter[0].equalTo(dataSnapshot.numChildren()) {
            List<Message> msgs = FirebaseHelper.this.beaconMessageList;
            FirebaseHelper.this.beaconMessageList = null;
            FirebaseHelper.this.messageByBeaconListener.onSuccess(msgs);
          }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
          FirebaseHelper.this.messageByBeaconListener.onFail(databaseError);
        }
      });
    }
  }

  @Override
  public void onCancelled(DatabaseError databaseError) {
    FirebaseHelper.this.messageByBeaconListener.onFail(databaseError);
  }
});