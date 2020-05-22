public class Caching {
    public static void main(String[] args) throws IOException {
        Observable<String> observable = doSomethingExpensive().cache();
        observable.subscribe(System.out::println);
        observable.subscribe(System.out::println);
    }

    private static Observable<String> doSomethingExpensive(){
        return Observable.create(subscriber -> {
            System.out.println("Doing something expensive");
            subscriber.onNext("A result");
            subscriber.onCompleted();
        });
    }
}