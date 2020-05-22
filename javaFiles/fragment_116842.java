Map<Y, A> map = new HashMap<>();

void putA(A a) {
    map.put(a.Y, a);
}

A getA(Y y) {
    return map.get(y);
}