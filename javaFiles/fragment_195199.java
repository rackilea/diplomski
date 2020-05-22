Observable.range(1, 5)
.subscribeOn(Schedulers.io())
.map(v -> Thread.currentThread() + "|" + v)
.observeOn(Schedulers.single())
.subscribe(w -> Thread.currentThread() + "||" + w);

Thread.sleep(1000);