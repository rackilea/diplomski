public static class TwoSet<T> extends AbstractSet<T> {
    T a = null;
    T b = null;

    @Override
    public boolean contains(Object o) {
        return o.equals(a) || o.equals(b);
    }

    @Override
    public boolean add(T t) {
        if(contains(t)){
            return false;
        }
        if ( a == null ) {
            a = t;
        } else if ( b == null ) {
            b = t;
        } else {
            throw new RuntimeException("Cannot have more than two items in this set.");
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o.equals(a)) {
            a = null;
            return true;
        }
        if(o.equals(b)) {
            b = null;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return (a == null ? 0 : 1) + (b == null ? 0 : 1);
    }

    @Override
    public Iterator<T> iterator() {
        List<T> list;
        if (a == null && b == null) {
            list = Collections.emptyList();
        } else {
            if (a == null) {
                list = Arrays.asList(b);
            } else if (b == null) {
                list = Arrays.asList(a);
            } else {
                list = Arrays.asList(a, b);
            }
        }
        return list.iterator();
    }

}