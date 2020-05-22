.subscribeOn(Schedulers.io())
.map(it -> {
    log.info("Current Thread:", Thread.currentThread().name)
    return it;
})
.observeOn(Schedulers.computation())
.map(it -> {
    log.info("Current Thread:", Thread.currentThread().name)
    return it;
})
.flatMap(..... -> {