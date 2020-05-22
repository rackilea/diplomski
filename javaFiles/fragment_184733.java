re = shoppingListStore.enumerateRecords(null, null, false);

while (re.hasNextElement())
{
    int id = re.nextRecordId();
    // read current values of item
    byte [] itemRecord = shoppingListStore.getRecord(id);
    // deserialise byte array
    newItemObject.fromByteArray(itemRecord);
    // set item status to purchased
    newItemObject.setItemStatus("Purchased");
    // create new bytearray and call newitemobject . tobytearray method to return a byte array of the object (using UTF8 encoded strings~)
    byte[] itemData = newItemObject.toByteArray();

    // update shoppinglist store record with new byte array
    shoppingListStore.setRecord(id, itemData, 0, itemData.length);
}