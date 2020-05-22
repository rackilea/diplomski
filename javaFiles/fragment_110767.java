public class DbOnSubscribe<T> implements Observable.OnSubscribe<T> {

    private DbObservable<T> dbObservable;

    @Override
    public void call(Subscriber<? super T> subscriber) {
        String sql = dbObservable.getSql(); //Access SQL param
        subscriber.onNext( (T) sql ); //Use subscriber
        subscriber.onCompleted();
    }

    //Set back-reference
    public void setDbObservable(DbObservable<T> dbObservable) {
        this.dbObservable = dbObservable;
    }
}