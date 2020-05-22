boolean add (int i) {
    if (super.add(i)) {
        setTotal();
        return true;
    }
    return false;
}