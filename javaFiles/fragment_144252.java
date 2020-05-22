@Override
public void call(Subscriber<? super JsonElement> subscriber) {
    try (Realm realm = Realm.getInstance(mRealmConfig)) {
        SomeJson someJson = realm.where(SomeJson.class)
                    .equalTo("type", type)
                    .equalTo("id", id)
                    .findFirst();

        if (someJson == null || !someJson.isDataValid()) {
            Logger.d(TAG, "Did not find value for id: " + id + " for type: " + type);
            subscriber.onNext(null);
            subscriber.onCompleted();
            return;
        }

        JsonElement val = (new JsonParser()).parse(someJson.jsonString);
        subscriber.onNext(val);
        subscriber.onCompleted();
    }
}