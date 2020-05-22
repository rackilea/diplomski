public boolean removeAll(Collection<?> c) {
    for (each element e of this) {
        if (c.contains(e)) {
            this.remove(e);
        }
    }
}