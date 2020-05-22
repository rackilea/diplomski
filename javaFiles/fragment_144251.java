try (Realm realm = Realm.getInstance(realmConfig)) {
    realm.beginTransaction();
    realm.copyToRealmOrUpdate(someData);
    realm.commitTransaction();
} catch (Exception e) {
    realm.cancelTransaction();
}