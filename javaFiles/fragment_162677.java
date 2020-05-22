class MyMap<ID, E> extends HashMap<ID, E extends Versioned & HasId<ID>> {

public void put(E elem) {
    if (containsKey(elem.getId()) {
        E exist = get(elem.getId());
        if (elem.version.isGreater(exist.version)) super.put(elem.getId(), elem);
    } else {
        super.put(elem.getId(), elem);
    }
}