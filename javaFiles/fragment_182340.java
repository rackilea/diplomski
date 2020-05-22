int m = 10;
    int n = 8;
    Observable<Integer> numbersStream = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .publish();

    Observable<Integer> firstNItemsStream = numbersStream.take(n)
            .map(i -> i * 2);

    Observable<Integer> remainingItemsStream = numbersStream.skip(n)
            .map(i -> i * 3);

    Observable.merge(firstNItemsStream, remainingItemsStream)
            .subscribe(integer -> System.out.println("result = " + integer));
    numbersStream.connect();