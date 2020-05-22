public class DbObservableTest {

    public static void main(String[] args) {
        DbConnector srcDb = new DbConnector();

        srcDb.getObservable()
                .sql("some SQL")
                .subscribe(System.out::println);
    }
}