Observable.create<Boolean> { 
    // use emitter here
}
     .timeout(3, TimeUnit.SECONDS)
     .onErrorReturn { if (it is TimeoutException) false else throw it } 
     .subscribe { println("onNext $it") }