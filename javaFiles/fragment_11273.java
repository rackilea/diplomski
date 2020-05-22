fun zipLiveData(vararg liveItems: LiveData<*>): LiveData<ArrayList<Any?>> {
    return MediatorLiveData<ArrayList<Any?>>().apply {
        val zippedObjects = ArrayList<Any?>()
        liveItems.forEach {
            addSource(it) { item ->
                zippedObjects.add(item)
                if (zippedObjects.size == liveItems.size) {
                    value = zippedObjects
                    zippedObjects.clear()
                }
            }
        }
    }
}