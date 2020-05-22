//If you know the LiveDatas won't get null values
fun zipLiveData(vararg liveItems: LiveData<*>): LiveData<ArrayList<Any?>> {
    return MediatorLiveData<ArrayList<Any?>>().apply {
        var zippedObjects = arrayOfNulls<Any>(liveItems.size)
        liveItems.forEachIndexed { index, liveData ->
            addSource(liveData) { item ->
                zippedObjects[index] = item
                if (!zippedObjects.contains(null)) {
                    value = zippedObjects.toCollection(ArrayList())
                    zippedObjects = arrayOfNulls(liveItems.size)
                }
            }
        }
    }
}

//Incase your LiveDatas might have null values
fun zipLiveDataWithNull(vararg liveItems: LiveData<*>): LiveData<ArrayList<Any?>> {
    return MediatorLiveData<ArrayList<Any?>>().apply {
        val zippedObjects = arrayOfNulls<Any>(liveItems.size)
        val zippedObjectsFlag = BooleanArray(liveItems.size)
        liveItems.forEachIndexed { index, liveData ->
            addSource(liveData) { item ->
                zippedObjects[index] = item
                zippedObjectsFlag[index] = true
                if (!zippedObjectsFlag.contains(false)) {
                    value = zippedObjects.toCollection(ArrayList())
                    for(i in 0 until liveItems.size) {
                        zippedObjectsFlag[i] = false
                    }
                }
            }
        }
    }
}