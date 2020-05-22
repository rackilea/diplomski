public Realm unpersistedRealm(){
    RealmConfiguration myConfig = new RealmConfiguration.Builder()
            .name(UUID.randomUUID().toString())
            .inMemory()
            .build();
    return Realm.getInstance(myConfig);
}