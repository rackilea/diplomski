Set<MyObject<?,?>> mySet = getSet();

public <T> Set<T> getSet() {
    Set<T> set = new HashSet<>();
    // ...
    return set;
}

class MyObject<T,U> {}