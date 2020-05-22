Realm realm = null;
try {
   realm = Realm.getDefaultInstance();
   realm.executeTransaction(new Realm.Transaction() {
       @Override
       public void execute(Realm realm) {
            MyObjectExtendingRealmObject myObject = new MyObjectExtendingRealmObject("John");
            realm.insertOrUpdate(myObject); // could be copyToRealmOrUpdate
       }
   });
} finally {
    if(realm != null) {
        realm.close();
    }
}