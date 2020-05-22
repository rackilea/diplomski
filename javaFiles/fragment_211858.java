public class RxUser {
    private RxUser() {}

    public static Observable<User> observe(final User user) {
        return Observable.create((emitter) -> {
              final User.ChangeListener changeListener = (user) -> {
                  emitter.onNext(user);
              }

              emitter.setDisposable(Disposables.fromAction(() -> { user.removeChangeListener(listener); }));

              user.addChangeListener(listener);
        });
    }