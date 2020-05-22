val list = arrayListOf<Single<String>>()
list.add(Single.just("hello"))
list.add(Single.just("world"))

Single.zip(list) { args -> Arrays.asList(args) }
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation())
        .subscribe()