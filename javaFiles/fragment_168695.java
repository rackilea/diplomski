final FirstTime time = new FirstTime();
time.setId(1); // existing ID
time.setSomeValue("blah"); // new value for field
realm.executeTransaction(... {
    //realm.copyToRealmOrUpdate(time); //if you do not use the managed proxy, use insertOrUpdate() instead
    realm.insertOrUpdate(time);
});