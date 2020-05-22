Observable.just("1", "2")
            .compose(withSchedulers<ObservableTransformer<String, String>>())
            .subscribe(System.out::println)

    Single.just(3)
            .compose(withSchedulers<SingleTransformer<Int, Int>>())
            .subscribe(Consumer { println(it) })

    Completable.defer { Completable.complete()  }
            .compose(withSchedulers<CompletableTransformer>())
            .subscribe { println("completed") }