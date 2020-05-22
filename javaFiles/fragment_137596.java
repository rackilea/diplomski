public class ObjectList {

    private int h;

    private Object obj1;
    private Object obj2;
    private Object obj3;
    private Object obj4;

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ObjectList))
            return false;

        final ObjectList that = (ObjectList) o;
        return that.obj1.equals(obj1) && that.obj2.equals(obj2)
            && that.obj3.equals(obj3) && that.obj4.equals(obj4);
    }

    @Override
    public int hashCode() {
        // caches the hashcode since it could be costly to recompute every time
        // but this assumes that your object is essentially immutable 
        // (which it should be if you are using equals/hashCode. If this is not
        // true and you want to just temporarily use this when doing the duplicate
        // test, move the h variable definition from the object level to this method
        // and remove this if statement.
        if (h != 0)
            return h;

        h = obj1.hashCode();
        h = h * 31 + obj2.hashCode();
        h = h * 31 + obj3.hashCode();
        h = h * 31 + obj4.hashCode();
        return h;
    }

}

public Collection<ObjectList> duplicates(
        final Collection<ObjectList> someObjectsList) {

    final Set<ObjectList> unique = new HashSet<ObjectList>(someObjectsList);
    final ArrayList<ObjectList> ret = new ArrayList<ObjectList>(someObjectsList);
    for (final ObjectList o : unique) {
        ret.remove(o);
    }

    // The ret list now contains the duplicate instances; instances 
    // with more than two occurrences will occur multiple times still in
    // this list.
    return ret;

    // If you want a list of unique duplicate instances then, comment out the above
    // return and uncomment this one.
    // return new HashSet<ObjectList>(ret);
}