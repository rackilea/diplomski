Observable.just(id)
            .observeOn(Schedulers.io())
            .map(new Function<String, Person>() {
                @Override
                public Person apply(@NonNull String id) throws Exception {
                    Realm realm = Realm.getDefaultInstance();

                    Person person = realm.copyFromRealm(realm.where(Person.class).equalTo("id", id).findFirst());

                    realm.close();

                    return person;
                }
            })
            .switchMap(new Function<Person, Observable<Directions>>() {
                @Override
                public Observable<Directions> apply(@NonNull Pair<String, Person> pair) throws Exception {
                    // assuming that id is available by getId
                    return Pair(person.getId(), Utils.getRemoteService().getDirections(person.getAddress())); // retrofit
                }
            })
            .map(new Function<Pair<String, Directions>, Object>() {
                @Override
                public Object apply(@NonNull Pair<String, Directions> pair) throws Exception {

                    // how do I get the id here to store the data to the correct person
                    // pair.first contains the id
                    // pair.second contains the Directions
                    return null;
                }
            })
            .subscribe();