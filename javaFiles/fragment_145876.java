Observable.just(1,2,3) // creation of observable happens on Computational-Threads
            .subscribeOn(Schedulers.computation()) // subscribeOn happens only once in chain. Nearest to source wins
            .map(integer -> integer) // map happens on Computational-Threads
            .observeOn(AndroidSchedulers.mainThread()) // Will switch every onNext to Main-Thread
            .subscribe(integer -> {
                // called from mainThread
            });