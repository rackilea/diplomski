Observable<User> observable = userService.me();
observable.observeOn(AndroidSchedulers.mainThread())
.filter(new Predicate<User >() {
        @Override
        public boolean test(@NonNull final User user) throws Exception {
            return user.hasPaidDues(); // or something like this
        }
    })
.subscribe(...);