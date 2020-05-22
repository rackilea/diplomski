public class RetryWhenEnter {
    public static void main(String[] args) {
        AtomicInteger d = new AtomicInteger();
        Observable<Integer> source = Observable.just(1);

        source.flatMap(v -> {
            if (d.incrementAndGet() < 3) {
                return Observable.error(new RuntimeException());
            }
            return Observable.just(v);
        })
        .retryWhen(err -> {
            return err.flatMap(e -> {
                System.out.println(Thread.currentThread() + " Error!");
                PublishSubject<Integer> choice = PublishSubject.create();
                SwingUtilities.invokeLater(() -> {
                    int c = JOptionPane.showConfirmDialog(null, 
                        e.toString() + "\r\nRetry?", "Error",
                        JOptionPane.YES_NO_OPTION);
                    if (c == JOptionPane.YES_OPTION) {
                        choice.onNext(1);
                    } else {
                        choice.onCompleted();
                    }
                });
                return choice;
            });
        }).subscribe(System.out::println, 
                Throwable::printStackTrace);
    }
}