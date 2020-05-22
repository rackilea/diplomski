// You could get primitive lists from fastutil, gs, hppc or trove
LongList keysToPut = keysToPutThreadLocal.get();
keysToPut.clear();
IntList valuesToPut = valuesToPutThreadLocal.get();
valuesToPut.clear();

for (LongIntCursor cur = map.cursor(); cur.moveNext();) {
    long key = cur.key();
    int value = cur.value();
    if (checkSomething(key, value)) {
        cur.remove(); // remove the entry
    } else {
        // want to insert a <newKey, newValue> entry
        keysToPut.add(newKey);
        valuesToPut.add(newValue);
    }
}
// bulk insert
for (int i = 0, toPut = keysToPut.size(); i < toPut; i++) {
    map.put(keysToPut.get(i), valuesToPut.get(i));
}