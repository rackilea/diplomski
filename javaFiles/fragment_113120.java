Class<Comparable> cls = Comparable.class;
for (Field f : fieldList) {
    if (cls.isAssignableFrom(f.getType())) {
        Comparable c = (Comparable) f.get(this);
        int r = c.compareTo((Comparable) f.get(other));
        if (r != 0) {
            return r;
        }
    }
}