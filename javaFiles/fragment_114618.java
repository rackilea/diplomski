inline fun <reified T> withSchedulers(): T {
    when (T::class) {
        ObservableTransformer::class  -> return ObservableTransformer<Unit, Unit> {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        } as T
        SingleTransformer::class      -> return SingleTransformer<Unit, Unit> {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        } as T
        CompletableTransformer::class -> return CompletableTransformer {
            it.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        } as T
    }
    throw IllegalArgumentException("not a valid Transformer type")
}