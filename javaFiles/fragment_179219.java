public <T extends RealmModel> Observable<List<T>> getWhere(RealmQueryProvider<T> queryFactory) {
    return Observable.defer(() -> {
        Realm realm = Realm.getDefaultInstance();
        return queryFactory.create(realm).asObservable()
                .filter(results -> ((RealmResults<T>) results).isLoaded())
                .map(o -> realm.copyFromRealm((RealmResults<T>) o))
                .doOnUnsubscribe(() -> closeRealm(realm));
    });
}

public interface RealmQueryProvider<T extends RealmModel> {
    RealmResults<T> create(Realm realm);
}

// example
Observable<List<Dog>> dogs = dbService.getWhere((realm) -> realm.where(Dog.class).findAll());