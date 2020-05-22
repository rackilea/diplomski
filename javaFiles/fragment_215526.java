Realm realm;

@Override
public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    realm = Realm.getDefaultInstance();
    realm.executeTransactionAsync(new Realm.Transaction() {
        public void execute(Realm realm) {
            MyObjectExtendingRealmObject myObject = new MyObjectExtendingRealmObject("John");
            realm.insertOrUpdate(myObject); // could be copyToRealmOrUpdate
        }
    });
}

@Override
public void onDestroy() {
    super.onDestroy();
    if(realm != null) { // don't trust old devices
        realm.close();
    }
}