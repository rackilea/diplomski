Map<Key, Value> map = getMap(); // map generating is hidden

Map<Key, Value> tempMap = new HashMap<>();
for (Iterator<Key> keyIterator = map.keySet().iterator(); keyIterator.hasNext();) {
    Key key = keyIterator.next();
    if (isToRemove(key)) {
        keyIterator.remove();
    }
    else {
        tempMap.put(key, getNewValue());
    }
}

map.putAll(tempMap);