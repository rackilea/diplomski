// This function simply stores a Realm model for all the data that has been uploaded to the server
private fun markDataAsUploaded(dataToUpload: List<CallLog>) {
    realm = Realm.getDefaultInstance()
    for (data in dataToUpload) {
        realm.beginTransaction()
        val callLogUploaded = realm.createObject(CallLogUploaded::class.java)
        callLogUploaded.callDate = data.callDate

        realm.commitTransaction()
    }
}