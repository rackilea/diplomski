@Override
public int compareTo(MyObject o) {
    return Comparator.<MyObject, String> comparing(obj -> obj.name)
                     .thenComparingInt(obj -> obj.index)
                     .compare(this, o);
}