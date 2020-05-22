public class Datasource {

    public Observable<List<User>> users() {
        return Observable.just(Arrays.asList(
                new User("1", "Foo"), new User("2", "Bar")
        ));
    }

    public Observable<List<Pet>> pets(User user) {
        return Observable.just(Arrays.asList(
                new Pet(user.getName() + "'s cat"),
                new Pet(user.getName() + "'s dog")
        ));
    }
}