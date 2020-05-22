@Test
fun slidingWindow() {
    val events = Flowable.just(
            Data(5, 1.0),
            Data(10, 1.5),
            Data(30, 2.8),
            Data(40, 3.2),
            Data(60, 3.8),
            Data(90, 4.2))
            .observeOn(Schedulers.io())
    val windows = window(windowSize = 3, slideSize = 1, data = events).toList().blockingGet()
    Assert.assertNotNull(windows)
    Assert.assertFalse(windows.isEmpty())
}

fun window(windowSize: Int, slideSize: Int, data: Flowable<Data>): Flowable<List<Int>> = window(
        from = 0,
        to = windowSize,
        slideSize = slideSize,
        data = data)

fun window(from: Int, to: Int, slideSize: Int, data: Flowable<Data>): Flowable<List<Int>> {
    val window = data.takeWhile { it.time <= to }.skipWhile { it.time < from }.map { it.data }
    val tail = data.skipWhile { it.time <= from + slideSize }
    val nonEmptyWindow = window.toList().filter { !it.isEmpty() }
    val nextWindow = nonEmptyWindow.flatMapPublisher {
        window(from + slideSize, to + slideSize, slideSize, tail).observeOn(Schedulers.io())
    }
    return nonEmptyWindow.toFlowable().concatWith(nextWindow)
}

data class Data(val data: Int, val time: Double)