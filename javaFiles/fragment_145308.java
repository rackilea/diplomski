public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<K> i = iterator(); i.hasNext(); ) {
            if (c.contains(i.next())) {
                i.remove();
                modified = true;
            }
        }
        return modified;
    }