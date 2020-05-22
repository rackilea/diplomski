final CountDownLatch sync = new CountDownLatch(1);

DatabaseReference ref = database.getReference();
ref.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        System.out.println(dataSnapshot.getChildrenCount());
        Object object = dataSnapshot.getValue(Object.class);
        String json = new Gson().toJson(object);
        log.info(json);
        sync.countDown();
    }

    @Override
    public void onCancelled(DatabaseError error) {
        log.info("error");
        sync.countDown();
    }
});

sync.await();