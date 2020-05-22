realm.beginTransaction()
for (data in dataToUpload) {
    val callLogUploaded = realm.createObject(CallLogUploaded::class.java)
    callLogUploaded.callDate = data.callDate
}
realm.commitTransaction()