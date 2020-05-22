void addPrefixes(Map<Integer, User> names) { // 1
    // update names
}

Map<Integer, User> getPrefixed(Map<Integer, User> names) { // 2
    // update names
    return names;
}

Map<Integer, User> getPrefixed(Map<Integer, User> names) { // 3
    // create copy, e.g. use Java8 stream;
    return namesCopy;
}