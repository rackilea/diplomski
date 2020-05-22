class MyObject {
    // snip

    @Override
    public boolean equals(Object o) {
        // boilerplate junk here
        if (!o instanceof MyObject) return false;
        MyObject other = (MyObject) o;
        return this.getObjID() == other.getObjID();
    }

    @Override
    public int hashCode() {
        return this.getObjID();
    }

    // snip
}