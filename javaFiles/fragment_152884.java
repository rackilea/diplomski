public Observable<List<Foo>> getFoosById(List<String> fooIds) {
   return Observable.defer(() -> {
       try(Realm realm = Realm.getInstance(fooRealmConfiguration)) { //try-finally also works
           RealmQuery<Foo> findFoosByIdQuery = realm.where(Foo.class);
           for(String id : fooIds) {
               findFoosByIdQuery.equalTo(FooFields.ID, id);
               findFoosByIdQuery.or(); // please guarantee this works?
           }
           RealmResults<Foo> results = findFoosByIdQuery.findAll();
           return Observable.just(realm.copyFromRealm(results));
       }
   }).subscribeOn(Schedulers.io());
}