// shared between all threads
ConcurrentMap<Integer, Boolean> map = new ConcurrentHashMap<>();

public boolean isVisit(Integer integer) {
    return map.putIfAbsent(integer, Boolean.TRUE) != null;
}

private void DFSearch(Stack<Integer> st) {
    if(!isVisit(st.pop())) {
       ...
    }
}