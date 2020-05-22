final RealmConfiguration realmConfiguration = realm.getConfiguration();
r.executeTransaction((realm) -> {
    for(Class<? extends RealmModel> clazz : realmConfiguration.getRealmObjectClasses()) {
        if(clazz != Table12.class) {
            realm.delete(clazz);
        }
    }
});