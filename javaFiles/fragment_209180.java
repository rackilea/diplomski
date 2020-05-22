double[] arrayInMap = hash.get(key);
    if (arrayInMap == null) {
        hash.put(key, valuesToAdd);
    } else {
        if (arrayInMap.length != valuesToAdd.length) {
            throw new IllegalStateException("Key "+ key + ": cannot add " + valuesToAdd.length
                    + " values to array of length " + arrayInMap.length);
        }
        for (int ix = 0; ix < arrayInMap.length; ix++) {
            arrayInMap[ix] += valuesToAdd[ix];
        }
    }