data class RealmWatcher<T>(
    val results: RealmResults<T>,
    val handler: (RealmResults<T>) -> Unit
) {
    fun attach() {
        handler(results)
        results.addChangeListener(handler)
    }
    fun detach() {
        results.removeChangeListener(handler)
    }
}