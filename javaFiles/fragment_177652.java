public void add(T objToAdd) {
    if (arr.size() % 2 == 0) {
        arr.add(0, objToAdd);
    } else {
        arr.add(objToAdd);
    }
}