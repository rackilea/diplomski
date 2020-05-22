public class DbConnector {

    public DbObservable<String> getObservable() {
        DbOnSubscribe<String> onSub = new DbOnSubscribe<String>();
        DbObservable<String> obs = new DbObservable<>(onSub);
        onSub.setDbObservable(obs);
        return obs;
    }
}