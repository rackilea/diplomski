val flowable = Flowable.create<Int>( {
    it.onNext(1)
    it.onNext(2)
    it.onComplete()
}, BackpressureStrategy.MISSING)

val publishSubject = PublishSubject.create<Int>()
val flowableFromSubject = publishSubject.toFlowable(BackpressureStrategy.MISSING)
//This data will be dropepd unless something is subscribed to the flowable.
publishSubject.onNext(1)
publishSubject.onNext(2)
publishSubject.onComplete()