public boolean replace(List<E> list, E oldE, E newE) {
    if (list == null) {
        return false;
    }
    int index = list.indexOf(oldE);
    if (index > 0) {
        list.set(index, newE);
        return true;
    }
    for (int i = 0, l = list.size(); i < l; i++) {
        List<E> children = list.get(i).children;
        if (replace(children, oldE, newE)) {
            return true;
        }
    }
    return false;
}