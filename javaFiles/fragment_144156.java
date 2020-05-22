class MapBuilder<T,U> {
    @JvmName("invokeWithT")
    operator fun invoke(arg: T): MapBuilder<T, U> {
        return this
    }

    @JvmName("InvokeWithU") // technically don't need both of these
    operator fun invoke(arg: U): MapBuilder<T, U> {
        return this
    }
}