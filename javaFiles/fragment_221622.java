for (data in dataToUpload) {
    realm.beginTransaction()
    val callLogUploaded = realm.createObject(CallLogUploaded::class.java)
    callLogUploaded.callDate = data.callDate

    realm.commitTransaction()
}