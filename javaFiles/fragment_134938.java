// after calling this mapLeft holds the combined data
public void merge(Map<> mapLeft, Map<> mapRight) {
    // go over all the keys of the right map
    for (String key : mapRight.keySet()) {
        // if the left map already has this key, merge the maps that are behind that key
        if (mapLeft.containsKey(key)) {
            merge(mapLeft.get(key), mapRight.get(key));
        } else {
            // otherwise just add the map under that key
            mapLeft.put(key, mapRight.get(key));
        }
    }
}