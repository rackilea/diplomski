boolean imeiId = false;
boolean androidId = false;
....

//Set the desire ID to true

CollectionReference usersRef = db.collection("users");

Query query = null;
if (imeiId) {
    query = usersRef.whereEqualTo("imei_Id", ".....");
} else if (androidId) {
    query = usersRef.whereEqualTo("android_Id", ".....");
} else if (uuId) {
    ...
}