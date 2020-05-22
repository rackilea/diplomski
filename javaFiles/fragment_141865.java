datasource.users()
        .flatMap(new Func1<List<User>, Observable<User>>() {
            @Override
            public Observable<User> call(List<User> users) {
                return Observable.from(users);
            }
        })
        .flatMap(new Func1<User, Observable<User>>() {
            @Override
            public Observable<User> call(final User user) {
                return datasource.pets(user)
                        .map(new Func1<List<Pet>, User>() {
                            @Override
                            public User call(List<Pet> pets) {
                                return user.copyWithPets(pets);
                            }
                        });
            }
        })
        .toList()
        .subscribe(new Action1<List<User>>() {
            @Override
            public void call(List<User> users) {
                for (User user : users) {
                    Log.d(TAG, "user: " + user.toString());
                }
            }
        });