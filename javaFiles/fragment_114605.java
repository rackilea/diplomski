val a = BehaviorSubject.create<Int>().apply {
    onNext(1)
}.doOnEach { EventReporter.d(TAG, it.value?.toString() ?: "") }

val b = BehaviorSubject.create<Int>().apply {
    onNext(2)
}.doOnEach { EventReporter.d(TAG, it.value?.toString() ?: "") }

Observable.combineLatest(listOf(a, b), { args: Collection<Int> -> args}