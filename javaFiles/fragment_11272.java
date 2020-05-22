fun zipLiveData(vararg liveItems: LiveData<*>): LiveData<ArrayList<Any>> {
    //MediatorLiveData used to merge multiple LiveDatas
    return MediatorLiveData<ArrayList<Any>>().apply {
        val zippedObjects = ArrayList<Any>()
        liveItems.forEach {
            //Add each LiveData as a source for the MediatorLiveData
            addSource(it) { item ->
                //Add value to list
                item?.let { it1 -> zippedObjects.add(it1) }
                if (zippedObjects.size == liveItems.size) {
                    //If all the LiveData items has returned a value, save that value in MediatorLiveData.
                    value = zippedObjects
                    //Clear the list for next time
                    zippedObjects.clear()
                }
            }
        }
    }
}