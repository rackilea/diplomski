proc(o);
proc(list);

public void proc(Object o) {
    proc(Collections.singleton(o));
}

public void proc(Collection<Object> collection) {
    // pre
    for (Object o : collection) {
        // main
    }
    // post
}