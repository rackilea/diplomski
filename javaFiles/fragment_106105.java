for (LongIntCursor cur = map.cursor(); cur.moveNext();) {
    long key = cur.key();
    int value = cur.value();
    if (checkSomething(key, value)) {
        cur.remove(); // remove the entry
    } else {
        cur.setValue(newValue); // update the value
    }
}