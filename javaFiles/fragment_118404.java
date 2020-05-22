AType get(int n) {
    Links<AType> current = list;
    while (n > 0 && current instanceof Cons) {
        current = current.getNext();
        n--;
    }
    return current.getElem();
}